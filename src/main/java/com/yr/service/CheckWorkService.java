package com.yr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.CheckWorkDao;
import com.yr.entry.CheckTime;
import com.yr.entry.CheckWork;
import com.yr.entry.Page;
import com.yr.util.DateUtils;

@Service
public class CheckWorkService{
	
	@Autowired
	private CheckWorkDao checkWorkDao;
	
	/**
	 * 添加考勤
	 * @param cw
	 * @return
	 */
	public boolean add(CheckWork cw){
		String currentDate = DateUtils.getCurrentDate();
		if (getCwBy(cw.getStuCode(),cw.getCtCode(),currentDate)) { //存在表示已经考勤了,不需要再考勤
			return false;
		}
		String baseTime = checkWorkDao.getBaseTimeByCtCode(cw.getCtCode());
		if (cw.getIsLate() == 0) { //正常考勤
			cw.setIsNote(0);
			cw.setLateTime(0);
			cw.setRetyTime(baseTime);//默认标准时间到表示没迟到即可
		}else if (cw.getIsLate() == 1) { //＝1迟到    需要计算了
			// 从迟到时间表中查出正常上课时间,计算迟到多长时间
			String bateTime = currentDate+" "+baseTime;
			String retyTime =  currentDate+" "+cw.getRetyTime();
			long lateTime = DateUtils.getDistanceTimes(bateTime,retyTime);
			cw.setLateTime(new Long(lateTime).intValue()); //迟到分钟
			cw.setIsNote(0);
		}else if (cw.getIsLate() == -1) { //特殊上课时间
			// 从迟到时间表中查出正常上课时间,计算迟到多长时间
			String bateTime = currentDate+" "+cw.getBaseTime();
			String retyTime =  currentDate+" "+cw.getRetyTime();
			long lateTime = DateUtils.getDistanceTimes(bateTime,retyTime);
			cw.setLateTime(new Long(lateTime).intValue()); //迟到分钟
			cw.setIsNote(0);
			cw.setIsLate(1);
		}else {//=2旷课 =3请假
			cw.setLateTime(0); 
		}
		return checkWorkDao.add(cw);
	}
	
	/**
	 * 打卡签到
	 * @param stuCode
	 * @return
	 */
	public long signIn(String stuCode){
		String ctCode = DateUtils.getAmPmNt(); //获取是上午下午晚上
		if (ctCode.equals("-1")) {
			long lo = -2L;
			return lo;
		}
		String currentDate = DateUtils.getCurrentDate();
		if (getCwBy(stuCode,ctCode,currentDate)) { //存在表示已经考勤了,不需要再考勤
			long lo = -1L;
			return lo;
		}
		CheckWork cw = new CheckWork();
		cw.setCtCode(ctCode);
		cw.setStuCode(stuCode);
		cw.setIsLate(1);
		cw.setIsNote(0);
		String retyTime = DateUtils.getCurrentTime();
		cw.setRetyTime(retyTime);
		String bateTime = currentDate+" "+checkWorkDao.getBaseTimeByCtCode(ctCode);
		long lateTime = DateUtils.getDistanceTimes(bateTime,currentDate+" "+retyTime);
		if (lateTime <= 0) { //负数表示没迟到
			lateTime = 0;
			cw.setIsLate(0);
		}
		cw.setLateTime(new Long(lateTime).intValue()); //迟到分钟
		checkWorkDao.add(cw);
		return lateTime;
	}
	
	/**
	 * 根据学生code,考勤时间段code,考勤日期查询是否有过考勤
	 * @param stuCode
	 * @param ctCode
	 * @param ckDate
	 * @return false 还没有考勤,true已考勤
	 */
	public boolean getCwBy(String stuCode,String ctCode,String ckDate){
		CheckWork cw = checkWorkDao.getCwBy(stuCode, ctCode, ckDate);
		if (null == cw) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * 得到所有考勤情况list
	 * @return
	 */
	public Page<CheckWork> getCwAll(Page<CheckWork> page){
		return checkWorkDao.getCwAll(page);
	}
	
	/**
	 * 得到所有考勤时间标准
	 * @return
	 */
	public List<CheckTime> getCtAll(){
		return checkWorkDao.getCtAll();
	}
	
	/**
	 * 分成当天考勤报告
	 * @param ctCode AM,PM,NT 上午 下午 晚上
	 * @return
	 */
	public List<CheckWork> getCwToday(String ctCode){
		String today = DateUtils.getCurrentDate();
		List<CheckWork> list = checkWorkDao.getCwToday(today, ctCode);
		return list;
	}
}