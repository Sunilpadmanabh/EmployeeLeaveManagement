package com.model;

public class Employee 
{
	private String employeeId;
	private String name;
	private String emailId;
	private String password;
	private String dept;
	private int holiday;
	private int planned;
	private int medical;
	private boolean isManager;
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getHoliday() {
		return holiday;
	}
	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}
	public int getPlanned() {
		return planned;
	}
	public void setPlanned(int planned) {
		this.planned = planned;
	}
	public int getMedical() {
		return medical;
	}
	public void setMedical(int medical) {
		this.medical = medical;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	
}
