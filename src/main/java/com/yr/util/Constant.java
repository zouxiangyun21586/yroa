package com.yr.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {

	
	public static Map<String,String> ctMap = new HashMap<String,String>();
	static {
		ctMap.put("AM", "上午");
		ctMap.put("PM", "下午");
		ctMap.put("NT", "晚上");
	}
	
	public static Map<String,String> isLateMap = new HashMap<String,String>();
	static {
		isLateMap.put("0", "正常考勤");
		isLateMap.put("1", "迟到");
		isLateMap.put("2", "旷课");
		isLateMap.put("3", "请假");
	}
	
	public static final String SOURCE = "客户端";

	public static final String SUCCESS = "0000";

	public static final String FAIL = "1111";

	public static final String MESSAGE = "message";

	public static final String RESPONSE_ADDFAIL = "数据添加错误！！";

	public static final String RESPONSE_UPDFAIL = "数据修改错误！！";

	public static final String RESPONSE_DELFAIL = "数据删除错误！！";

	public static final String RESPONSE_QUEFAIL = "数据查询错误！！";

	public static final Double DEDUCT_MONEY = 1.2;

	public static final Double OVERDUEFINE_MONEY = 2.0;

	public static final Integer ISBACKYES = 0;

	public static final Integer ISBACKNO = 1;

	public static final Integer ISRETURNYES = 0;

	public static final Integer ISRETURNNO = 1;

	public static final Double LevelNO = 0.0;

	public static final Double LevelOne = 1.0;

	public static final Double LevelTwo = 1.0;

	public static final Double LevelThree = 0.3;

	public static final Double LevelFour = 0.1;

	public static final Integer Book = 1;

	public static final Integer Journal = 2;
}
