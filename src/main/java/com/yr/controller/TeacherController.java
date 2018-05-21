package com.yr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Teacher;
import com.yr.service.TeacherService;

@Controller // 表示这个是一个Controller
@RequestMapping("teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@ResponseBody
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	public List<Teacher> getList(Model model) {
		List<Teacher> list = teacherService.getList();
		return list;
	}
	
}
