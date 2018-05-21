package com.yr.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Clas;
import com.yr.entry.Page;
import com.yr.service.ClasService;

@Controller // 表示这个是一个Controller
@RequestMapping("clas")
public class ClasController {

	@Autowired
	private ClasService clasService;
	
	/**
	 * 添加账户
	 * @param cw
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Clas clas, Model model) {
		try {
			String name = new String(clas.getName().getBytes("iso-8859-1"),"utf-8");
			clas.setName(name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		clasService.insert(clas);
		return "redirect:list.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/page",method=RequestMethod.POST)
	public Page<Clas> page(Clas clas,@RequestParam(value="pageNum") Integer pageNum, Model model) {
		Page<Clas> page= new Page<>();
		page.setT(clas);
		page.setPageNum(pageNum);
		page = clasService.queryPage(page);
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	public List<Clas> getList() {
		return clasService.getList();
	}
	
	/**
	 * 毕业
	 * @param id
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/finish",method=RequestMethod.POST)
	public String finish(@RequestParam(value="id") Integer id, Model model) {
		clasService.finish(id);
		return "true";
	}
	
	/**
	 * 开课
	 * @param id
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/start",method=RequestMethod.POST)
	public String start(@RequestParam(value="id") Integer id, Model model) {
		clasService.start(id);
		return "true";
	}
}
