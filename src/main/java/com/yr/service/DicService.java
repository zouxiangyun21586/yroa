package com.yr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.mybatis.DicMapper;
import com.yr.entry.Dic;

@Service
public class DicService{
	
	@Autowired
	private DicMapper dicMapper;
	 
	public List<Dic> getListByType(String type){
		List<Dic> list = dicMapper.selectByType(type);
		return list;
	}
	
	public String getKeyByVal(String val){
		return "1";	
	}
	
}