package com.seed.beans;

/*this is pojo class*/

public class LeaveApplication<T> {

	private T applicationId; // geneic
	private String reason;
	private String description;
	private int noOfDays;
	// Employee employee; //employee class not created
	private String employeeName;
	private int employeeId;

	public T getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(T applicationId) {
		this.applicationId = applicationId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
