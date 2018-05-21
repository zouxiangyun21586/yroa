package com.yr.util;

public class RoundUtils {

	public static long getRound3(){
		int max = 9999;
		int min = 1000;
		Long a = Math.round(Math.random()*(max-min)+min);
		return a;
	}
	 
}
