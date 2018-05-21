package com.yr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Dic;
import com.yr.service.DicService;

@Controller // 表示这个是一个Controller
@RequestMapping("dic")
public class DicController {

	@Autowired
	private DicService dicService;
	
	 
	
	@ResponseBody
	@RequestMapping(value="/select",method=RequestMethod.POST)
	public List<Dic> select(@RequestParam(value="type") String type, Model model) {
		List<Dic> list = dicService.getListByType(type);
		return list;
	}
	
}
