package com.model;

public class ManagerLeaveView 
{
	private int slNo;
	private String employeeId;
	private String name;
	private String emailId;
	private String dept;
	private String dateFrom;
	private String dateto;
	private String leaveType;
	private String descp;
	private String status;
	
	//later.ManagerViewEmployeeController.if
	private int total;
	private int consumed;
	private int askedDays;
	
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getConsumed() {
		return consumed;
	}
	public void setConsumed(int consumed) {
		this.consumed = consumed;
	}
	public int getAskedDays() {
		return askedDays;
	}
	public void setAskedDays(int askedDays) {
		this.askedDays = askedDays;
	}
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateto() {
		return dateto;
	}
	public void setDateto(String dateto) {
		this.dateto = dateto;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
