package com.yr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.yr.entry.CheckTime;
import com.yr.entry.CheckWork;
import com.yr.entry.Page;
import com.yr.entry.Stu;

@Repository
public class CheckWorkDao extends PageDao {

	/**
	 * 添加考勤
	 * @param cw
	 * @return true成功
	 */
	public boolean add(CheckWork cw) {
		String sql = "insert into check_work (clas_id,stu_code,ct_code,"
				+ " rety_time,late_time,is_late,ck_time,create_time,is_note,clas_name,stu_name,ct_name) "
				+ " values(?,?,?,?,?,?,SYSDATE(),SYSDATE(),?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Stu stu = getStuByStuCode(cw.getStuCode());
			pstmt.setInt(1, stu.getClasId());
			pstmt.setString(2, cw.getStuCode());
			pstmt.setString(3, cw.getCtCode());
			pstmt.setString(4, cw.getRetyTime());
			pstmt.setInt(5, cw.getLateTime());
			pstmt.setInt(6, cw.getIsLate()); 
			pstmt.setInt(7, cw.getIsNote());
			pstmt.setString(8, getClasNameByClasId(stu.getClasId()));
			pstmt.setString(9, stu.getName());
			pstmt.setString(10, getCtNameByCtCode(cw.getCtCode()));
			//System.out.println(pstmt.asSql());
			pstmt.executeUpdate();
			//ResultSet rs = pstmt.getGeneratedKeys();
			/*if (rs.next()) {
				Long id = rs.getLong(1);
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 导出考勤报表
	 * @return
	 */
	public List<CheckWork> getAllExcel(CheckWork search){
		StringBuilder sb = new StringBuilder();
		sb.append("select date_format(cw.ck_time,'%Y-%m-%d') as ck_time,cw.stu_name as stu_name, ")
			.append(" ct.name as ct_name,ct.start_time as start_time,cw.rety_time as rety_time, ")
			.append(" CASE cw.is_late WHEN 0 THEN '正常考勤' WHEN 1 THEN '迟到' WHEN 2 THEN '旷课' ELSE '请假' END as is_late, ")
			.append(" cw.late_time as late_time,CASE cw.is_note WHEN 0 THEN ")
			.append(" CASE cw.is_late WHEN 3 THEN '没交请假条' ELSE '/' END ")
			.append(" ELSE '交了请假条' END as is_note ")
			.append(" from check_work cw,check_time ct where cw.ct_code = ct.code ");
		if (null != search.getStuName().trim() && !"".equals(search.getStuName().trim())) {
			sb.append(" and stu_name = '").append(search.getStuName().trim()).append("' ");
		}
		if (null != search.getDayOf().trim() && !"".equals(search.getDayOf().trim())) {
			sb.append(" and ct_code = '").append(search.getDayOf().trim()).append("' ");
		}
		if (null != search.getDateStart().trim() && !"".equals(search.getDateStart().trim())) {
			sb.append(" and cw.ck_time BETWEEN '").append(search.getDateStart().trim()).append(" 00:00:00' ");
		}
		if (null != search.getDateEnd().trim() && !"".equals(search.getDateEnd().trim())) {
			sb.append(" and '").append(search.getDateEnd().trim()).append(" 23:59:59' ");
		}	
		sb.append("  order by cw.ck_time desc");
		List<CheckWork> list = new ArrayList<>();
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sb.toString());
			ResultSet rs = pstmt.executeQuery(sb.toString());
			while (rs.next()) {
				CheckWork cw = new CheckWork();
				cw.setCkTime(rs.getDate("ck_time"));
				cw.setStuName(rs.getString("stu_name"));
				cw.setCtName(rs.getString("ct_name"));
				cw.setStartTime(rs.getString("start_time"));
				cw.setRetyTime(rs.getString("rety_time"));
				cw.setIsLateStr(rs.getString("is_late"));
				cw.setLateTime(rs.getInt("late_time"));
				cw.setIsNoteStr(rs.getString("is_note"));
				list.add(cw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据学生code,考核时间段code,考核时间得到是否有考勤数据
	 * @param stuCode
	 * @param ctCode
	 * @param ckDate
	 * @return
	 */
	public CheckWork getCwBy(String stuCode,String ctCode,String ckDate){
		String sql = "select * from check_work where stu_code = '"+stuCode+"' "
				+ " and ct_code = '"+ctCode+"' "
				+ " and DATE_FORMAT(ck_time ,'%Y-%m-%d') = '"+ckDate+"' ";
		CheckWork cw = new CheckWork();
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				cw.setId(rs.getInt(1));
				cw.setClasId(rs.getInt(2));
				cw.setClasName(rs.getString(3));
				cw.setStuCode(rs.getString(4));
				cw.setStuName(rs.getString(5));
				cw.setCtCode(rs.getString(6));
				cw.setCtName(rs.getString(7));
				cw.setCkTime(rs.getDate(8));
				cw.setRetyTime(rs.getString(9));
				cw.setLateTime(rs.getInt(10));
				cw.setIsLate(rs.getInt(11));
				cw.setIsNote(rs.getInt(12));
				cw.setCreateTime(rs.getDate(13));
				return cw;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据clasId获取clasName
	 * @param clasId
	 * @return String clasName
	 */
	public Page<CheckWork> getCwAll(Page<CheckWork> page){
		List<CheckWork> list = new ArrayList<>();
		list.clear();
		String sql = "select * from check_work  where 1 = 1  ";
		CheckWork t = page.getT();
		if (null != t.getDateStart() && !"".equals(t.getDateStart())) {
			sql += " and ck_time >= '"+ t.getDateStart()+" 00:00:00' ";
		}
		if (null != t.getDateEnd() && !"".equals(t.getDateEnd())) {
			sql += " and ck_time <= '"+ t.getDateEnd()+" 23:59:59' ";
		}
		if (null != t.getStuName() && !"".equals(t.getStuName())) {
			sql += " and stu_name = '"+ t.getStuName()+"' ";
		}
		if (null != t.getDayOf() && !"".equals(t.getDayOf())) {
			sql += " and ct_code = '"+ t.getDayOf()+"' ";
		}
		sql += " order by create_time desc ";
		sql += " LIMIT "+page.getLimitNum()+","+page.getPageSize();
		setTotalCount(page,sql);
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				CheckWork cw = new CheckWork();
				cw.setId(rs.getInt(1));
				cw.setClasId(rs.getInt(2));
				cw.setClasName(rs.getString(3));
				cw.setStuCode(rs.getString(4));
				cw.setStuName(rs.getString(5));
				cw.setCtCode(rs.getString(6));
				cw.setCtName(rs.getString(7));
				cw.setCkTime(rs.getDate(8));
				cw.setRetyTime(rs.getString(9));
				cw.setLateTime(rs.getInt(10));
				cw.setIsLate(rs.getInt(11));
				cw.setIsNote(rs.getInt(12));
				cw.setCreateTime(rs.getDate(13));
				list.add(cw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setDataList(list);
		return page;
	}
	
	/**
	 * 根据clasId获取clasName
	 * @param clasId
	 * @return String clasName
	 */
	public List<CheckWork> getCwToday(String today,String ctCode){
		List<CheckWork> list = new ArrayList<>();
		String sql = "select * from check_work where DATE_FORMAT(ck_time,'%Y-%m-%d')='"+today+"'"
				+ " and ct_code ='"+ctCode +"' order by ck_time desc ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				CheckWork cw = new CheckWork();
				cw.setId(rs.getInt(1));
				cw.setClasId(rs.getInt(2));
				cw.setClasName(rs.getString(3));
				cw.setStuCode(rs.getString(4));
				cw.setStuName(rs.getString(5));
				cw.setCtCode(rs.getString(6));
				cw.setCtName(rs.getString(7));
				cw.setCkTime(rs.getDate(8));
				cw.setRetyTime(rs.getString(9));
				cw.setLateTime(rs.getInt(10));
				cw.setIsLate(rs.getInt(11));
				cw.setIsNote(rs.getInt(12));
				cw.setCreateTime(rs.getDate(13));
				list.add(cw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据clasId获取clasName
	 * @param clasId
	 * @return String clasName
	 */
	public String getClasNameByClasId(int clasId){
		String clasName = "1";
		String sql = "select name from clas where id =" +clasId;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				clasName = rs.getString(1); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clasName;
	}
	
	/**
	 * 根据stu ID,获取clas id
	 * @param id
	 * @return clasId
	 */
	public int getClasIdByStuCode(String stuCode){
		Stu stu = getStuByStuCode(stuCode);
		return stu.getClasId();
	}
	
	/**
	 * 根据stu ID,获取Stu
	 * @param stuCode
	 * @return Stu
	 */
	public Stu getStuByStuCode(String stuCode){
		Stu stu = new Stu();
		String sql = "select name,clas_id,id,code from stu where code ='" +stuCode+"'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				stu.setName(rs.getString(1));
				stu.setClasId(rs.getInt(2));
				stu.setId(rs.getInt(3));
				stu.setCode(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}
	
	
	/**
	 * 根据ID,获取考勤时间段的名称
	 * @param id
	 * @return name
	 */
	public String getCtNameByCtCode(String ctCode){
		CheckTime ct = getCheckTimeByCtCode(ctCode);
		return ct.getTimeName();
	}
	
	
	/**
	 * 根据ID,获取迟到基础时间
	 * @param id
	 * @return 基础开始时间
	 */
	public String getBaseTimeByCtCode(String ctCode){
		CheckTime ct = getCheckTimeByCtCode(ctCode);
		return ct.getStartTime();
	}
	
	/**
	 * 根据ID,获取迟到基础时间
	 * @param code
	 * @return CheckTime
	 */
	public CheckTime getCheckTimeByCtCode(String code){
		CheckTime ct = new CheckTime();
		String sql = "select id,name,start_time,end_time,code from check_time where code ='" +code+"'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				ct.setId(rs.getInt(1));
				ct.setTimeName(rs.getString(2));
				ct.setStartTime(rs.getString(3));
				ct.setEndTime(rs.getString(4));
				ct.setCode(rs.getString("code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ct;
	}
	
	/**
	 * 查询考勤标准
	 * @return CheckTime
	 */
	public List<CheckTime> getCtAll(){
		List<CheckTime> list = new ArrayList<>();
		String sql = "select id,name,start_time,end_time,code from check_time ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				CheckTime ct = new CheckTime();
				ct.setId(rs.getInt(1));
				ct.setTimeName(rs.getString(2));
				ct.setStartTime(rs.getString(3));
				ct.setEndTime(rs.getString(4));
				ct.setCode(rs.getString("code"));
				list.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
