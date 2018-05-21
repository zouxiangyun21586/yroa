package com.yr.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.yr.entry.CheckTime;
@Repository
public interface CheckTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckTime record);

    int insertSelective(CheckTime record);

    CheckTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckTime record);

    int updateByPrimaryKey(CheckTime record);
}