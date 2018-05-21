package com.yr.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.yr.annotation.Loggable;
import com.yr.entry.Account;
import com.yr.util.Constant;
import com.yr.util.DateUtils;

@Component
public class AopLogHandler {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 前置通知
	 * 
	 * @param joinpoint
	 */
	public void before(JoinPoint joinPoint) {

	}

	/**
	 * 后置通知
	 * 
	 * @param joinpoint
	 */
	public void after(JoinPoint joinPoint) {

	}

	/**
	 * 返回通知
	 * 
	 * @param joinPoint
	 */
	public void returning(JoinPoint point) {
		Method method = isMethod(point);
		// 得到操作方法上的自定义注解
		Loggable loggable = method.getAnnotation(Loggable.class);
		if (loggable == null) {
			return;
		}
		// 得到操作人
		String optMan = getOptMan(point, loggable);
		// --------- 日志表数据 --------- (操作时间 ,描述,操作者,日志类型(记录的是那张表的日志),操作类型,来源)
		// 0000代表成功
		String sql = "insert into log (optTime,`desc`,optMan,logType,optType,source,Constant,errorMessage) values(?,?,?,?,?,?,?,?) ";
		jdbcTemplate.update(sql, DateUtils.getCurrentDateTime(), loggable.describe(), optMan, loggable.module(),
				loggable.optType(), "客户端", Constant.SUCCESS, "");
	}

	/**
	 * 异常通知
	 */
	public void throwing(JoinPoint point, Exception e) {
		String message = e.getMessage();
		if (null != message) {
			if(message.length()>=500){
				message = message.substring(0,500);
			}
			Method method = isMethod(point);
			// 得到操作方法上的自定义注解
			Loggable loggable = method.getAnnotation(Loggable.class);
			if (loggable == null) {
				return;
			}
			// 得到操作人
			String optMan = getOptMan(point, loggable);
			String sql = "insert into log (optTime,`desc`,optMan,logType,optType,source,Constant,errorMessage) values(?,?,?,?,?,?,?,?) ";
			jdbcTemplate.update(sql, DateUtils.getCurrentDateTime(), loggable.describe(), optMan, loggable.module(),
					loggable.optType(), Constant.SOURCE, Constant.FAIL, message);
		}
	}

	/**
	 * 得到当前登陆的操作人名称操作人名称
	 * 
	 * @param point
	 * @param loggable
	 * @return
	 */
	private String getOptMan(JoinPoint point, Loggable loggable) {
		Object[] objArr = point.getArgs();
		// 得到操作的用户名名
		String optMan = (String) request.getSession().getAttribute("account");
		if ("LOGIN".equals(loggable.optType())) {
			Account acc = (Account) objArr[0];
			optMan = acc.getAccount();
		}
		return optMan;
	}

	/**
	 * 判断使用注解的是不是该方法,是的话就得到
	 * 
	 * @param point
	 * @return
	 */
	private Method isMethod(JoinPoint point) {
		String methodName = point.getSignature().getName();// 获取方法名
		Class<?> targetClass = point.getTarget().getClass();// 获取目标对象的类名
		Method method = null;
		// 得到该类的所有方法
		for (Method mt : targetClass.getMethods()) {
			// 判断得到的方法名与实际操作的方法名称是否相同
			if (methodName.equals(mt.getName())) {
				method = mt;
				break;
			}
		}
		return method;
	}

}
