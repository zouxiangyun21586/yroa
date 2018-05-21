package com.yr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	static DateFormat dfymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static DateFormat dfymd = new SimpleDateFormat("yyyy-MM-dd");
	static DateFormat dfhms = new SimpleDateFormat("HH:mm:ss");

	public static String dataToStringYMD(Date d) {
		return dfymd.format(d);
	}

	public static String dataToStringYMDHMS(Date d) {
		return dfymdhms.format(d);
	}

	/**
	 * 得到当前日期
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrentDate() {
		return dfymd.format(new Date());
	}

	/**
	 * 得到当前日期和时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDateTime() {
		return dfymdhms.format(new Date());
	}

	/**
	 * 得到当前时间
	 * 
	 * @return HH:mm:ss
	 */
	public static String getCurrentTime() {
		return dfhms.format(new Date());
	}

	/**
	 * 得到当前小时数
	 * 
	 * @return HH
	 */
	public static int getCurrentHour() {
		int y, m, d, h, mi, s;
		Calendar cal = Calendar.getInstance();
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH);
		d = cal.get(Calendar.DATE);
		h = cal.get(Calendar.HOUR_OF_DAY);
		mi = cal.get(Calendar.MINUTE);
		s = cal.get(Calendar.SECOND);
		return h;
	}

	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		return y;
	}

	/**
	 * 获取当前是上午,下午还是晚上 AM上午 PM下午 NT晚上 -1不正确
	 * 
	 * @return String AM/PM/NT
	 */
	public static String getAmPmNt() {
		GregorianCalendar ca = new GregorianCalendar();
		if (ca.get(GregorianCalendar.AM_PM) == 0) {
			return "AM";
		} else {
			int hour = getCurrentHour();
			if (hour >= 13 && hour < 18) {
				return "PM";
			} else if (hour >= 18 && hour <= 23) {
				return "NT";
			}
		}
		return "-1";
	}

	/**
	 * 两个时间相差距离多少分
	 * 
	 * @param baseTime
	 *            时间参数 1 格式：yyyy-MM-dd HH:mm:ss
	 * @param nowTime
	 *            时间参数 2 格式：yyyy-MM-dd HH:mm:ss
	 * @return 正数表示迟到多少分钟,-数表示早到多少分也就是没迟到 long[] 返回值为：{天, 时, 分, 秒}
	 * 
	 */
	public static long getDistanceTimes(String baseTime, String nowTime) {

		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = dfymdhms.parse(baseTime);
			two = dfymdhms.parse(nowTime);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			diff = time2 - time1;
			return (diff / (1000 * 60));
			/*
			 * if(time1<time2) { diff = time2 - time1; } else { diff = time1 - time2; }
			 */
			/*
			 * day = diff / (24 * 60 * 60 * 1000); hour = (diff / (60 * 60 * 1000) - day *
			 * 24); min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			 */
			// sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// long[] times = {day, hour, min, sec};
		// return day+" "+" "+hour +" "+min+" "+sec;
		return 0;
	}

	/**
	 * 两个时间相差距离多少年
	 * 
	 * @param baseTime
	 *            时间参数 1 格式：yyyy-MM-dd HH:mm:ss
	 * @param nowTime
	 *            时间参数 2 格式：yyyy-MM-dd HH:mm:ss
	 * @return 正数表示迟到多少分钟,-数表示早到多少分也就是没迟到 long[] 返回值为：{天, 时, 分, 秒}
	 * 
	 */
	public static long getDistanceYear(String baseTime, String nowTime) {
		try {
			Date one = dfymdhms.parse(baseTime);
			Date two = dfymdhms.parse(nowTime);
			return getDistanceYear(one, two);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static long getDistanceYear(Date baseTime, Date nowTime) {
			long time1 = baseTime.getTime();
			long time2 = nowTime.getTime();
			long diff;
			diff = time2 - time1;
			return (diff / (1000 * 60 * 60 * 24) / 365);
			/*
			 * if(time1<time2) { diff = time2 - time1; } else { diff = time1 - time2; }
			 */
			/*
			 * day = diff / (24 * 60 * 60 * 1000); hour = (diff / (60 * 60 * 1000) - day *
			 * 24); min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			 */
			// sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
		// long[] times = {day, hour, min, sec};
		// return day+" "+" "+hour +" "+min+" "+sec;
	}

}
