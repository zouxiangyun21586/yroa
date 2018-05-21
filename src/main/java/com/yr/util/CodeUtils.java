package com.yr.util;

public class CodeUtils {

	public static String getStuCode() {
		String code = "S"+DateUtils.getCurrentYear()+getRound3();
		return code;
	}
	
	public static String getClasCode(String year) {
		String code = "C"+DateUtils.getCurrentYear()+getRound3();
		return code;
	}
	
	public static String getTeacherCode(String year) {
		String code = "T"+DateUtils.getCurrentYear()+getRound3();
		return code;
	}
	
	public static long getRound3(){
		int max = 9999;
		int min = 1000;
		Long a = Math.round(Math.random()*(max-min)+min);
		return a;
	}
	 
}
