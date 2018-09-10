package com.hccms.beans;

public class Patient {
	private String patientid; //do generic
	private Name Name;
	private Address address;
	private String bloodgroup,type,gender,symptons;
	private String dateOfBirth,chekinDate;
	private String PatientMobileNumber;
	private Medical_History mHistory;
	private PatientDiagnosis pDiagnosis;
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public Name getName() {
		return Name;
	}
	public void setName(Name name) {
		Name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSymptons() {
		return symptons;
	}
	public void setSymptons(String symptons) {
		this.symptons = symptons;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCheckinDate() {
		return chekinDate;
	}
	public void setCheckinDate(String arrivalDate) {
		this.chekinDate = arrivalDate;
	}
	public String getPatientMobileNumber() {
		return PatientMobileNumber;
	}
	public void setPatientMobileNumber(String patientMobileNumber) {
		PatientMobileNumber = patientMobileNumber;
	}
	public Medical_History getmHistory() {
		return mHistory;
	}
	public void setmHistory(Medical_History mHistory) {
		this.mHistory = mHistory;
	}
	public PatientDiagnosis getpDiagnosis() {
		return pDiagnosis;
	}
	public void setpDiagnosis(PatientDiagnosis pDiagnosis) {
		this.pDiagnosis = pDiagnosis;
	}
	
	
	
	
}
