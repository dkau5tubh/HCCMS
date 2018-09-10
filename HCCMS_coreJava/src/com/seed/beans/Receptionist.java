package com.seed.beans;

public class Receptionist {

	private Appointment appointment;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Receptionist [appointment=" + appointment + "]";
	}
	
	
}
