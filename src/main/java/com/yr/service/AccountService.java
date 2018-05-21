package com.yr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.mybatis.AccountMapper;
import com.yr.entry.Account;

@Service
public class AccountService{
	
	@Autowired
	private AccountMapper accountMapper;
	
	public void insert(Account account){
		accountMapper.insert(account);
	} 
	
}