package com.yr.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class BaseDao {
	volatile static Connection conn = null;
	static {
		if (conn == null){
			conn = getConn();
		}
	}
	private static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.86:3306/yroa", "root",
					"root");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
