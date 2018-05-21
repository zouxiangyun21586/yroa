package com.yr.entry;

public class Stu {
	private Integer id;
	private String name;
	private String code;
	private Integer clasId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClasId() {
		return clasId;
	}
	public void setClasId(Integer clasId) {
		this.clasId = clasId;
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", code=" + code + ", clasId=" + clasId + "]";
	}
	 
}
