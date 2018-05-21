package com.yr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Page;
import com.yr.entry.Student;
import com.yr.service.StudentService;

@Controller // 表示这个是一个Controller
@RequestMapping("stu")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 添加学生
	 * @param cw
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Student stu, Model model) {
		studentService.insert(stu);
		return "redirect:/student/list.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/page",method=RequestMethod.POST)
	public Page<Student> page(Student stu,@RequestParam(value="pageNum") Integer pageNum, Model model) {
		Page<Student> page= new Page<>();
		page.setT(stu);
		page.setPageNum(pageNum);
		page = studentService.queryPage(page);
		return page;
	}
	
}
