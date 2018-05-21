package com.yr.entry;

import java.util.List;

/**
 * 分页封装类
 * @param <T>
 */
public class Page<T> {
	private Integer pageSize = 6; //每页多少条数据,默认10条
	private Integer pageCount = 0; //总页数，默认0页
	private Integer pageNum = 1; //当前多少页面,默认第1页
	private Integer totalCount = 0; //总数据条数,默认0条
	private Integer limitNum;
	private T t; //封装目标对象;
	private List<T> dataList; //数据集合
	
	
	/**
	 * 总页数
	 * @return
	 */
	public Integer getPageCount() {
		int t = totalCount % pageSize; //总数据条数取余总页数
		pageCount = totalCount / pageSize;//将数据总条数除以页数赋给变量pageCount,也就是分页的总页数
		if (t == 0) {//说明被整除
			return pageCount;//则返回总页数
		}else {
			return pageCount + 1;//不被整除则去掉小数多加1页
		}
	}
	public Integer getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * 总数据条数
	 * @return
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;//将总条数替换
		Integer inte = getPageCount();//得到总页数
		setPageCount(inte);//然后将总页数加进去
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
		/**
		 * 将当前页数按公式转化为limit的第一个参数的值
		 * sql limit的数据行下标   
		 * (当前页面-1) * 每页条数
		 * @return Integer
		 */
		setLimitNum((pageNum-1) * pageSize); 
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageCount=" + pageCount + ", pageNum=" + pageNum + ", t=" + t
				+ ", dataList=" + dataList + "]";
	}
	
}
