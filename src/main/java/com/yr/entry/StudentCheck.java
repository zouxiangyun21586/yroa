package com.yr.entry;

import java.util.Date;

public class StudentCheck {
    private Integer id;

    private String classCode;

    private String className;

    private String studentCode;

    private String studentName;

    private String checkTimeCode;

    private String checkTimeDesc;

    private Date checkTime;

    private Date retyTime;

    private Integer lateTime;

    private Integer isLate;

    private Integer isNote;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getCheckTimeCode() {
        return checkTimeCode;
    }

    public void setCheckTimeCode(String checkTimeCode) {
        this.checkTimeCode = checkTimeCode == null ? null : checkTimeCode.trim();
    }

    public String getCheckTimeDesc() {
        return checkTimeDesc;
    }

    public void setCheckTimeDesc(String checkTimeDesc) {
        this.checkTimeDesc = checkTimeDesc == null ? null : checkTimeDesc.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getRetyTime() {
        return retyTime;
    }

    public void setRetyTime(Date retyTime) {
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
}