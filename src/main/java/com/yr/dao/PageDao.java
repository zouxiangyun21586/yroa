package com.yr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yr.entry.Page;

public class PageDao extends BaseDao {//继承了BikBaseDao,则可以调用父类的方法获得Connection对象

	public void setTotalCount(Page<?> page,String sql){//这里需要两个参数,一个是page对象,一个是sql
		sql = sql.substring(0, sql.indexOf("LIMIT"));//从0下标到limit下标前的字符串全部截取成一个新变量
		sql = "select count(*) from ("+sql+") t";//查询出数据的总条数,t是一个虚拟表命名为,加条件比较实用
		try {
			ResultSet res = conn.createStatement().executeQuery(sql);//执行这个sql
			while (res.next()) {
				int totalCount = res.getInt(1);//将第一个值赋给int类型的totalCount变量
				page.setTotalCount(totalCount);//通过page对象将总条数传入
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
