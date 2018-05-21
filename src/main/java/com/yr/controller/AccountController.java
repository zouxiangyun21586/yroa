package com.yr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yr.entry.Account;
import com.yr.service.AccountService;

@Controller // 表示这个是一个Controller
@RequestMapping("acc")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	/**
	 * 添加账户
	 * @param cw
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Account account, Model model) {
		accountService.insert(account);
		return "redirect:account/list.jsp";
	}
	
}
