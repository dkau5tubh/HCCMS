package com.seed.beans;

/*this is pojo class*/

public class Test<T> {
	private T patientid; // do generic
	private int testid;
	private String testName, doctorName, type;
	private double testCost;
	private Date testDate;

	public T getPatientid() {
		return patientid;
	}

	public void setPatientid(T patientid) {
		this.patientid = patientid;
	}

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTestCost() {
		return testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Override
	public String toString() {
		return "Test [patientid=" + patientid + ", testid=" + testid + ", testName=" + testName + ", doctorName="
				+ doctorName + ", type=" + type + ", testCost=" + testCost + ", testDate=" + testDate + "]";
	}

}
