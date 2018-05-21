package com.yr.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yr.entry.Clas;
import com.yr.entry.Page;
@Repository
public interface ClasMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Clas record);

	int insertSelective(Clas record);

	Clas selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Clas record);

	int updateByPrimaryKey(Clas record);

	List<Clas> selectByPage(Page<Clas> page);

	List<Clas> getList();
}