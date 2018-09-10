package com.hccms.beans;

public class Account {
	private int transactionid;
	private Date transactionDate;
	private int patientid;
	private String patientName;
	private double totaldouble;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public double getTotaldouble() {
		return totaldouble;
	}
	public void setTotaldouble(double totaldouble) {
		this.totaldouble = totaldouble;
	}
	

}
