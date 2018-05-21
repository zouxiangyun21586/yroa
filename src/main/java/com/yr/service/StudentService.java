package com.yr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.mybatis.StudentMapper;
import com.yr.entry.Page;
import com.yr.entry.Student;
import com.yr.util.CodeUtils;
import com.yr.util.DateUtils;

@Service
public class StudentService{
	
	@Autowired
	private StudentMapper studentMapper;
	 
	public Page<Student> queryPage(Page<Student> page){
		List<Student> list = studentMapper.selectByPage(page);
		for (Student student : list) {
			long l = DateUtils.getDistanceYear(student.getBirth(), new Date());
			student.setAge(Integer.parseInt(Long.valueOf(l).toString()));	
		}
		page.setDataList(list);
		return page;
	}
	
	public void insert(Student student){
		student.setCode(CodeUtils.getStuCode());
		student.setYear(DateUtils.getCurrentYear()+"");
		studentMapper.insert(student);
	} 
	
}