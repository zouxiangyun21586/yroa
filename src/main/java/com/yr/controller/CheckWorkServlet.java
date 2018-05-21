package com.yr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.entry.CheckWork;
import com.yr.service.CheckWorkService;

public class CheckWorkServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuCode = request.getParameter("stuCode");//学生ID
		String ctCode = request.getParameter("ctCode"); //考勤类型(上午下午晚上)
		String retyTimeHour = request.getParameter("retyTimeHour");//实际到的时间
		String retyTimeMins = request.getParameter("retyTimeMins");//实际到的时间
		String isLate = request.getParameter("isLate"); //考勤情况
		String isNote = request.getParameter("isNote"); //是否有假条
		CheckWork cw = new CheckWork();
		cw.setStuCode(stuCode);
		cw.setCtCode(ctCode);
		cw.setRetyTime(retyTimeHour+":"+retyTimeMins+":00"); //组合实际到的时间
		Integer isLateInt = Integer.valueOf(isLate);
		cw.setIsLate(isLateInt);
		if (isLateInt == 3) { //请假了才填充是否有假条
			cw.setIsNote(Integer.valueOf(isNote));
		}else { //否则填充为0
			cw.setIsNote(0); 
		}
		CheckWorkService cwService = new CheckWorkService();
		boolean isR = cwService.add(cw);
		if (isR) {
			response.getWriter().write("1");
		}else {
			response.getWriter().write("-1");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/*@Override
	public void destroy() {
		try {
			FileWriter fw = new FileWriter("C:/Users/linjuanjuan111/Desktop/aa.txt");
			fw.write("销毁方法");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
