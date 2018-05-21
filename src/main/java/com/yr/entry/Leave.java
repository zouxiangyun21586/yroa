package com.yr.entry;

import java.util.Date;

public class Leave {
    private Integer id;

    private String classCode;

    private String className;

    private String studentCode;

    private String studentName;

    private Date leaveDate;

    private String leaveHour;

    private Integer leaveTimeLong;

    private String leaveDesc;

    private String leaveAccount;

    private String isAudit;

    private String auditDesc;

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

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getLeaveHour() {
        return leaveHour;
    }

    public void setLeaveHour(String leaveHour) {
        this.leaveHour = leaveHour == null ? null : leaveHour.trim();
    }

    public Integer getLeaveTimeLong() {
        return leaveTimeLong;
    }

    public void setLeaveTimeLong(Integer leaveTimeLong) {
        this.leaveTimeLong = leaveTimeLong;
    }

    public String getLeaveDesc() {
        return leaveDesc;
    }

    public void setLeaveDesc(String leaveDesc) {
        this.leaveDesc = leaveDesc == null ? null : leaveDesc.trim();
    }

    public String getLeaveAccount() {
        return leaveAccount;
    }

    public void setLeaveAccount(String leaveAccount) {
        this.leaveAccount = leaveAccount == null ? null : leaveAccount.trim();
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit == null ? null : isAudit.trim();
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}