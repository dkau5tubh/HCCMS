package com.hccms.beans;



import com.toedter.calendar.JDateChooser;

public class Appointment {
	
	private String patientId;  //dynamic datatype Changeable
	private String appointmentid; //dynamicaly changable

	private String appointmentDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private String bloodGrp;
	private String symptom;
	private String pMobilenNo;
	private Address address;
	private String gender;
	private String appointTo;
	
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(String appointmentid) {
		this.appointmentid = appointmentid;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String date) {
		this.dateOfBirth = date;
	}
	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getpMobilenNo() {
		return pMobilenNo;
	}
	public void setpMobilenNo(String string) {
		this.pMobilenNo = string;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAppointTo() {
		return appointTo;
	}
	public void setAppointTo(String appointTo) {
		this.appointTo = appointTo;
	}
	
	@Override
	public String toString() {
		return "Appointment [patientId=" + patientId + ", appointmentid=" + appointmentid + ", appointmentDate="
				+ appointmentDate + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", bloodGrp=" + bloodGrp + ", symptom="
				+ symptom + ", pMobilenNo=" + pMobilenNo + ", address=" + address + ", gender=" + gender
				+ ", appointTo=" + appointTo + "]";
	}
	
	
	
	

	
	      

}
