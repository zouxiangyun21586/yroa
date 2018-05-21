package com.yr.entry;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	private Integer id;

	private String name;

	private String code;

	private String year;

	private String classCode;

	private String sex;

	private Date birth;
	
	private Integer age;

	private String tel;

	private String addr;

	private String homeTel;

	private Date inTime;

	private Date createTime;

	private Date finishTime;

	private Date offerTime;

	private String offerIncome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode == null ? null : classCode.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}
	
	public Date getBirth() {
		return birth;
	}


    @DateTimeFormat(pattern = "yyyy-MM-dd")  
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr == null ? null : addr.trim();
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel == null ? null : homeTel.trim();
	}

	public Date getInTime() {
		return inTime;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getOfferTime() {
		return offerTime;
	}

	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}

	public String getOfferIncome() {
		return offerIncome;
	}

	public void setOfferIncome(String offerIncome) {
		this.offerIncome = offerIncome;
	}

}