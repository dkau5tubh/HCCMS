package com.seed.beans;

//This Is Pojo

public class Appointment<T> {

	private T appointmentId; // dynamic datatype Changeable
	private Date appointmentDate;
	private String patientName;
	private String patientAge;
	private long patientMobilenNo;

	public T getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(T appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientMobilenNo() {
		return patientMobilenNo;
	}

	public void setPatientMobilenNo(long patientMobilenNo) {
		this.patientMobilenNo = patientMobilenNo;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + ", patientName="
				+ patientName + ", patientAge=" + patientAge + ", patientMobilenNo=" + patientMobilenNo + "]";
	}

}
