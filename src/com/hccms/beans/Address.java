package com.hccms.beans;

public class Address {
	private String street;
	private String town;
	private String state;
	private String country;
	private String pin;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", town=" + town + ", state=" + state + ", country=" + country + ", pin="
				+ pin + "]";
	}
	
	
	
	
}
