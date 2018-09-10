package com.seed.beans;

/*this is pojo class*/

public class Reports<T> {
	private T repid;
	private Date date;
	private String patientName;
	private String description;
	private boolean result;

	public T getRepid() {
		return repid;
	}

	public void setRepid(T repid) {
		this.repid = repid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
