package com.yr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.mybatis.ClasMapper;
import com.yr.entry.Clas;
import com.yr.entry.Page;
import com.yr.util.DicUtils;
import com.yr.util.RoundUtils;

@Service
public class ClasService{
	
	@Autowired
	private ClasMapper clasMapper;
	
	/**
	 * 分页
	 * @param page
	 * @return
	 */
	public Page<Clas> queryPage(Page<Clas> page){
		List<Clas> list = clasMapper.selectByPage(page);
		page.setDataList(list);
		return page;
	}
	
	public void insert(Clas clas){
		String classCode = clas.getYear()+RoundUtils.getRound3();
		clas.setCode(classCode);
		clasMapper.insert(clas);
	} 
	
	/**
	 * 用于下拉
	 * @return
	 */
	public List<Clas> getList(){
		return clasMapper.getList();
	}
	
	/**
	 * 毕业
	 * @param id
	 */
	public void finish(Integer id) {
		Clas clas = new Clas();
		clas.setId(id);
		clas.setIsFinish(DicUtils.getClasFinishMark());
		clas.setFinishTime(new Date());
		clasMapper.updateByPrimaryKeySelective(clas);
	}
	
	/**
	 * 毕业
	 * @param id
	 */
	public void start(Integer id) {
		Clas clas = new Clas();
		clas.setId(id);
		clas.setStartTime(new Date());
		clasMapper.updateByPrimaryKeySelective(clas);
	}
	
}