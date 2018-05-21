package com.yr.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yr.entry.Teacher;
@Repository
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    List<Teacher> getList();
}