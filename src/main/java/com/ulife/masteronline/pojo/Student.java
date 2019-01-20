package com.ulife.masteronline.pojo;

public class Student {
	private int id;
	private String school_no;//学号
	private String name;
	private String major;
	private String grade;
	private String school;//学院
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool_no() {
		return school_no;
	}
	public void setSchool_no(String school_no) {
		this.school_no = school_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString(){
		return (this.school_no+this.name+this.major+this.grade+this.school);
	}
}
