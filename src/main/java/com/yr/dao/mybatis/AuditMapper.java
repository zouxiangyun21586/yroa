package com.yr.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.yr.entry.Audit;

@Repository
public interface AuditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
}