package com.yr.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yr.entry.Page;
import com.yr.entry.Student;
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
	List<Student> selectByPage(Page<Student> page);
}