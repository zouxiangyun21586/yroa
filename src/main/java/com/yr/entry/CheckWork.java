package com.yr.entry;

import java.sql.Date;

public class CheckWork extends Search{
	private Integer id;
	private Integer clasId; //班级ID
	private String clasName;//班级名称
	private String stuCode; //学生ID
	private String stuName; //学生名称
	private String ctCode; //考勤ID
	private String ctName; //考勤名称(上午,下午,晚上)
	private Date ckTime; //考勤时间
	private String retyTime; //实际到时间
	private String baseTime; //特殊上课时间
	private Integer lateTime;//迟到时间(分钟)
	private Integer isLate; //是否迟到(0没迟到,1迟到,2旷课,3请假)
	private Integer isNote; // 是否有请假条(1有假条,0没有假条)
	private Date createTime;//数据创建时间
	private String startTime;
	private String isLateStr;
	private String isNoteStr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClasId() {
		return clasId;
	}
	public void setClasId(Integer clasId) {
		this.clasId = clasId;
	}
	public String getClasName() {
		return clasName;
	}
	public void setClasName(String clasName) {
		this.clasName = clasName;
	}
	public String getStuCode() {
		return stuCode;
	}
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCtCode() {
		return ctCode;
	}
	public void setCtCode(String ctCode) {
		this.ctCode = ctCode;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public Date getCkTime() {
		return ckTime;
	}
	public void setCkTime(Date ckTime) {
		this.ckTime = ckTime;
	}
	public String getRetyTime() {
		return retyTime;
	}
	public void setRetyTime(String retyTime) {
		this.retyTime = retyTime;
	}
	public Integer getLateTime() {
		return lateTime;
	}
	public void setLateTime(Integer lateTime) {
		this.lateTime = lateTime;
	}
	public Integer getIsLate() {
		return isLate;
	}
	public void setIsLate(Integer isLate) {
		this.isLate = isLate;
	}
	public Integer getIsNote() {
		return isNote;
	}
	public void setIsNote(Integer isNote) {
		this.isNote = isNote;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBaseTime() {
		return baseTime;
	}
	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getIsLateStr() {
		return isLateStr;
	}
	public void setIsLateStr(String isLateStr) {
		this.isLateStr = isLateStr;
	}
	public String getIsNoteStr() {
		return isNoteStr;
	}
	public void setIsNoteStr(String isNoteStr) {
		this.isNoteStr = isNoteStr;
	}
	@Override
	public String toString() {
		return "CheckWork [id=" + id + ", clasId=" + clasId + ", clasName=" + clasName + ", stuCode=" + stuCode
				+ ", stuName=" + stuName + ", ctCode=" + ctCode + ", ctName=" + ctName + ", ckTime=" + ckTime
				+ ", retyTime=" + retyTime + ", lateTime=" + lateTime + ", isLate=" + isLate + ", isNote=" + isNote
				+ ", createTime=" + createTime + "]";
	}
}
