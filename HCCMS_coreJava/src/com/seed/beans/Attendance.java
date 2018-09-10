package com.seed.beans;
//This Is Pojo
public class Attendance {

	private Date inTime;
	private String seniorDoctorId; // dynamic datatype Changeable

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getSeniorDoctorId() {
		return seniorDoctorId;
	}

	public void setSeniorDoctorId(String seniorDoctorId) {
		this.seniorDoctorId = seniorDoctorId;
	}

	@Override
	public String toString() {
		return "Attendance [inTime=" + inTime + ", seniorDoctorId=" + seniorDoctorId + "]";
	}

}
