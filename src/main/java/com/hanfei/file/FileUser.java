package com.hanfei.file;

import java.util.Date;

public class FileUser {
private Long id;
	
	private String userName;
	
	private String password;
	
	private String sign;
	
	private Date birthDay;
	
	private Integer age;
	
	private Double salary;
	
 
	public FileUser() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public FileUser(Long id, String userName, String password, String sign, Date birthDay, Integer age, Double salary) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.sign = sign;
		this.birthDay = birthDay;
		this.age = age;
		this.salary = salary;
	}
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getSign() {
		return sign;
	}
 
	public void setSign(String sign) {
		this.sign = sign;
	}
 
	public Date getBirthDay() {
		return birthDay;
	}
 
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
 
	public Integer getAge() {
		return age;
	}
 
	public void setAge(Integer age) {
		this.age = age;
	}
 
	public Double getSalary() {
		return salary;
	}
 
	public void setSalary(Double salary) {
		this.salary = salary;
	}
 
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", sign=" + sign + ", birthDay="
				+ birthDay + ", age=" + age + ", salary=" + salary + "]";
	}
	

}
