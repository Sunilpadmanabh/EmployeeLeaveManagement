package com.model;

public class ConsumedLeave 
{
    private String employeeId;
    private int consumed_plannedLeave;
    private int consumed_holidayLeave;
    private int consumed_medicalLeave;
    
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getConsumed_plannedLeave() {
		return consumed_plannedLeave;
	}
	public void setConsumed_plannedLeave(int consumed_plannedLeave) {
		this.consumed_plannedLeave = consumed_plannedLeave;
	}
	public int getConsumed_holidayLeave() {
		return consumed_holidayLeave;
	}
	public void setConsumed_holidayLeave(int consumed_holidayLeave) {
		this.consumed_holidayLeave = consumed_holidayLeave;
	}
	public int getConsumed_medicalLeave() {
		return consumed_medicalLeave;
	}
	public void setConsumed_medicalLeave(int consumed_medicalLeave) {
		this.consumed_medicalLeave = consumed_medicalLeave;
	}
    
}
