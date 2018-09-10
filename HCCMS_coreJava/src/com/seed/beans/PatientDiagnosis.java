package com.seed.beans;

public class PatientDiagnosis {
	private int diagnosisNumber,pid;
	private String diagnosisDetails,diagnosisRemark,other;
	private Date diagnosisDate;
	public int getDiagnosisNumber() {
		return diagnosisNumber;
	}
	public void setDiagnosisNumber(int diagnosisNumber) {
		this.diagnosisNumber = diagnosisNumber;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDiagnosisDetails() {
		return diagnosisDetails;
	}
	public void setDiagnosisDetails(String diagnosisDetails) {
		this.diagnosisDetails = diagnosisDetails;
	}
	public String getDiagnosisRemark() {
		return diagnosisRemark;
	}
	public void setDiagnosisRemark(String diagnosisRemark) {
		this.diagnosisRemark = diagnosisRemark;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Date getDiagnosisDate() {
		return diagnosisDate;
	}
	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}
	@Override
	public String toString() {
		return "PatientDiagnosis [diagnosisNumber=" + diagnosisNumber + ", pid=" + pid + ", diagnosisDetails="
				+ diagnosisDetails + ", diagnosisRemark=" + diagnosisRemark + ", other=" + other + ", diagnosisDate="
				+ diagnosisDate + "]";
	}
	
	
	
}
