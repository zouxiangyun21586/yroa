package com.yr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.CheckTime;
import com.yr.entry.CheckWork;
import com.yr.entry.Page;
import com.yr.service.CheckWorkExcelService;
import com.yr.service.CheckWorkService;

@Controller // 表示这个是一个Controller
@RequestMapping("cw")
public class CkeckWorkController {

	@Autowired
	private CheckWorkService checkWorkService;
	@Autowired
	private CheckWorkExcelService checkWorkExcelService;
	
	/**
	 * 添加考勤
	 * @param cw
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(CheckWork cw, Model model) {
		if (cw.getIsLate() == 3) { //请假了才填充是否有假条
			cw.setIsNote(1);
		}else { //否则填充为0
			cw.setIsNote(0); 
		}
		checkWorkService.add(cw);
		return "redirect:../ckwk/list.jsp";
	}
	
	/**
	 * 得到所有考勤情况
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list") //请求此方法
	public Page<CheckWork> list(CheckWork search) {
		Page<CheckWork> page = new Page<>();
		page.setT(search);
		page.setPageNum(Integer.valueOf(search.getPageNum()));
		page = checkWorkService.getCwAll(page);
		return page;  
	}
	
	/**
	 * 得到考勤标准
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ctList") //请求此方法
	public List<CheckTime> ctList() {
		List<CheckTime> list = checkWorkService.getCtAll();
		return list;  
	}
	
	/**
	 * 生成当天考勤报告
	 * @param ctCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/todayReport") //请求此方法
	public List<CheckWork> todayReport(@RequestParam(value="ctCode") String ctCode) {
		List<CheckWork> list = checkWorkService.getCwToday(ctCode+"");
		return list;  
	}
	
	/**
	 * 打卡签到
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/signIn") //请求此方法
	public String signIn(@RequestParam(value="stuCode") String stuCode) {
		long lateTime = checkWorkService.signIn(stuCode+"");
		return lateTime+"";
	}
	
	/*@ResponseBody
	@RequestMapping("/importExcelAll") //请求此方法
	public void importExcelAll(HttpServletRequest request,HttpServletResponse response,Writer out) throws IOException {
		File file = null;
		try {
			file = checkWorkExcelService.writeExcel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.reset();
        response.setContentType("text/html;charset=utf-8"); //中文乱码问题
        response.setContentType("application/x-msdownload");//设置为文件下载
        response.setHeader("Content-Disposition", "attachment;filename="+
        		new String(file.getName().getBytes("utf-8"),"ISO-8859-1")); //解决下载文件时中文不显示的问题,因为:HTTP头部的默认编码为ISO-8859-1
        int fileLength = (int) file.length();
        response.setContentLength(fileLength);
        如果文件长度大于0
        if (fileLength != 0) {
            创建输入流
            InputStream inStream = new FileInputStream(file);
            //byte[] buf = new byte[4096];
            创建输出流
            ServletOutputStream servletOS = response.getOutputStream();
            int readLength;
            while (((readLength = inStream.read()) != -1)) {
                servletOS.write(readLength);
            }
            inStream.close();
            servletOS.flush();
            servletOS.close();
        }
		//out.write("spring mvc servlet  api");
	}*/
	
	@RequestMapping("/exportExcelAll") //请求此方法
	public ResponseEntity<byte[]> exportExcelAll(CheckWork search) throws IOException {
		byte []body = null;
		File file = null;
		try {
			String stuName = new String(search.getStuName().getBytes("iso-8859-1"),"UTF-8");
			search.setStuName(stuName);
			file = checkWorkExcelService.exportExcel(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
        int fileLength = (int) file.length();
        /*如果文件长度大于0*/
        if (fileLength != 0) {
            /*创建输入流*/
            InputStream inStream = new FileInputStream(file);
            body = new byte[inStream.available()];
            inStream.read(body);
            
            HttpHeaders headers = new HttpHeaders();
            //headers.add("Content-Dispostion", "attachment;filename="+file.getName());
            //下载显示的文件名，解决中文名称乱码问题  
            String downloadFielName = new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
            //通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", downloadFielName); 
            //application/octet-stream ： 二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            HttpStatus statusCode = HttpStatus.OK; //HttpStatus.CREATED
            ResponseEntity<byte[]> respEn = new ResponseEntity<byte[]>(body	,headers,statusCode);
            inStream.close();
            return respEn;
        }
        return null;
        
        
         
	}
	
	
	
	
	

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public String get(@PathVariable("id") Integer id, Model model) {
		return "order/add";
	} 
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id, Model model) {
		System.out.println(id);
		model.addAttribute("msg", "Hello World! 你好springmvc注解  restful 删除 delete请求");
		return "order/add";
	} 
	 
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public String put(@PathVariable("id") Integer id, Model model) {
		System.out.println(id);
		model.addAttribute("msg", "Hello World! 你好springmvc注解  restful 修改 put请求");
		return "order/add";
	} 
	
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="userName") String userName,
			@RequestParam(value="age",required=false,defaultValue="0") int age, Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解   requestParam "+ userName+" age="+age);
		return "order/list";
	} 
	
	@RequestMapping(value="/testCookiesValue")
	public String testCookiesValue(@CookieValue(value="JSESSIONID") String sessionId,
			@RequestParam(value="age") Integer age, Model model) {
		model.addAttribute("msg", "Hello World! 你好springmvc注解   @CookieValue "+ sessionId+" age="+age);
		return "order/list";
	} 
	
	
	
}
