package com.seed.beans;

/*this is pojo class*/

public class Prescription<T> {

	private T perscriptionId; // dynamic datatype Changeable
	private Date prescriptionDate;
	private Medicine medicine;

	public T getPerscriptionId() {
		return perscriptionId;
	}

	public void setPerscriptionId(T perscriptionId) {
		this.perscriptionId = perscriptionId;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "Prescription [perscriptionId=" + perscriptionId + ", prescriptionDate=" + prescriptionDate + "]";
	}

}
