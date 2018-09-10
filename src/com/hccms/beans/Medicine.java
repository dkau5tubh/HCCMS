package com.hccms.beans;

public class Medicine {
	private int medicine;   //Dynamic datatype changeble
	private String medicineName;
	private int quantity;
	private int doses;
	private Date date;
	private String petientName;
	private String doctorName;
	private double medicineBill;
	public int getMedicine() {
		return medicine;
	}
	public void setMedicine(int medicine) {
		this.medicine = medicine;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDoses() {
		return doses;
	}
	public void setDoses(int doses) {
		this.doses = doses;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPetientName() {
		return petientName;
	}
	public void setPetientName(String petientName) {
		this.petientName = petientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public double getMedicineBill() {
		return medicineBill;
	}
	public void setMedicineBill(double medicineBill) {
		this.medicineBill = medicineBill;
	}
	@Override
	public String toString() {
		return "Medicine [medicine=" + medicine + ", medicineName=" + medicineName + ", quantity=" + quantity
				+ ", doses=" + doses + ", date=" + date + ", petientName=" + petientName + ", doctorName=" + doctorName
				+ ", medicineBill=" + medicineBill + "]";
	}
	
	
	

}
