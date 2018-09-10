package com.seed.beans;

/*this is pojo class*/

public class Patient<T> {
	private T patientid; // do generic
	private Name Name;
	private String address, bloodgroup, type, gender, symptons;
	private Date dateOfBirth, arrivalDate;
	private long PatientMobileNumber;
	private Medical_History mHistory;
	private PatientDiagnosis pDiagnosis;

	public T getPatientid() {
		return patientid;
	}

	public void setPatientid(T patientid) {
		this.patientid = patientid;
	}

	public Name getName() {
		return Name;
	}

	public void setName(Name name) {
		Name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public long getPatientMobileNumber() {
		return PatientMobileNumber;
	}

	public void setPatientMobileNumber(long patientMobileNumber) {
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

	@Override
	public String toString() {
		return "Patient [patientid=" + patientid + ", Name=" + Name + ", address=" + address + ", bloodgroup="
				+ bloodgroup + ", type=" + type + ", gender=" + gender + ", symptons=" + symptons + ", dateOfBirth="
				+ dateOfBirth + ", arrivalDate=" + arrivalDate + ", PatientMobileNumber=" + PatientMobileNumber
				+ ", mHistory=" + mHistory + ", pDiagnosis=" + pDiagnosis + "]";
	}

}
