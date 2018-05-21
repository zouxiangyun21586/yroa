package com.yr.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.yr.entry.StudentCheck;
@Repository
public interface StudentCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentCheck record);

    int insertSelective(StudentCheck record);

    StudentCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCheck record);

    int updateByPrimaryKey(StudentCheck record);
}