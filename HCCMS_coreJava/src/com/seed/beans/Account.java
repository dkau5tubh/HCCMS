package com.seed.beans;

public class Account<T> {
	private T transactionid;
	private Date transactionDate;
	private int patientid;
	private String patientName;
	private double totaldouble;
	public T getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(T transactionid) {
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
