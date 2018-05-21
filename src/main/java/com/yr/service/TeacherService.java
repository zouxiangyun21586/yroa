package com.yr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.mybatis.TeacherMapper;
import com.yr.entry.Teacher;

@Service
public class TeacherService{
	
	@Autowired
	private TeacherMapper teacherMapper;
	 
/*	public Page<Student> queryPage(Page<Student> page){
		List<Student> list = teacherMapper.selectByPage(page);
		page.setDataList(list);
		return page;
	}*/
	
	public void insert(Teacher t){
		teacherMapper.insert(t);
	} 
	
	/**
	 * 获取未离职的老师
	 * @return
	 */
	public List<Teacher> getList(){
		return teacherMapper.getList();
	}
	
}