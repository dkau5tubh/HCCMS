package com.hccms.beans;

import javax.swing.JLabel;

public class Ward {
private String building;
private String floor;
private int roomNo;
private String roomType;
private int noOfBeds;
private double price;


public Ward() {
	super();
	// TODO Auto-generated constructor stub
}

public Ward(String building, String floor, int roomNo, String roomType, int noOfBeds, double price) {
	super();
	this.building = building;
	this.floor = floor;
	this.roomNo = roomNo;
	this.roomType = roomType;
	this.noOfBeds = noOfBeds;
	this.price = price;
}

public String getBuilding() {
	return building;
}

public void setBuilding(String building2) {
	this.building = building2;
}

public String getFloor() {
	return floor;
}

public void setFloor(String floor) {
	this.floor = floor;
}

public int getRoomNo() {
	return roomNo;
}

public void setRoomNo(int roomNo) {
	this.roomNo = roomNo;
}

public String getRoomType() {
	return roomType;
}

public void setRoomType(String roomType) {
	this.roomType = roomType;
}

public int getNoOfBeds() {
	return noOfBeds;
}

public void setNoOfBeds(int noOfBeds) {
	this.noOfBeds = noOfBeds;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return "Ward [building=" + building + ", floor=" + floor + ", roomNo=" + roomNo + ", roomType=" + roomType
			+ ", noOfBeds=" + noOfBeds + ", price=" + price + "]";
}





}