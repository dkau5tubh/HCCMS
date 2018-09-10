package com.hccms.beans;

public class Prescription {
 
private String mediName;
private String quantity;
private String dosage;
private String remark;
public Prescription() {
	super();
	// TODO Auto-generated constructor stub
}
public Prescription(String mediName, String quantity, String dosage, String remark) {
	super();
	this.mediName = mediName;
	this.quantity = quantity;
	this.dosage = dosage;
	this.remark = remark;
}
public String getMediName() {
	return mediName;
}
public void setMediName(String mediName) {
	this.mediName = mediName;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getDosage() {
	return dosage;
}
public void setDosage(String dosage) {
	this.dosage = dosage;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
@Override
public String toString() {
	return "Prescription [mediName=" + mediName + ", quantity=" + quantity + ", dosage=" + dosage + ", remark=" + remark
			+ "]";
}



	
}
