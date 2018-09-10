package com.seed.beans;

/*this is pojo class*/

public class Ward<T> {
	private T ward; // Dynamic datatype changeble
	private String type;
	private double roomBill;
	private int bedId;

	public T getWard() {
		return ward;
	}

	public void setWard(T ward) {
		this.ward = ward;
	}

	public String getType() {
		return type;
	}

	public void setType(String firstname) {
		this.type = type;
	}

	public double getRoomBill() {
		return roomBill;
	}

	public void setRoomBill(String firstname) {
		this.roomBill = roomBill;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int ward) {
		this.bedId = bedId;
	}

	public void setRoomBill(double roomBill) {
		this.roomBill = roomBill;
	}

}
