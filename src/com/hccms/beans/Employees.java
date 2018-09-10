package com.hccms.beans;

import java.util.Date;

public class Employees {
	private String id;
	private String role;
	private Name fml;
	private String gender;
	private String dob;
	private String qualification;
	private Double salary;
	private String email;
	private String mobno;
	private String hiredate;
	private String department;
	private Address ad;
	private String bloodgp;
	private String shift;
	private String username;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Name getFml() {
		return fml;
	}
	public void setFml(Name fml) {
		this.fml = fml;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Address getAd() {
		return ad;
	}
	public void setAd(Address ad) {
		this.ad = ad;
	}
	public String getBloodgp() {
		return bloodgp;
	}
	public void setBloodgp(String bloodgp) {
		this.bloodgp = bloodgp;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", role=" + role + ", fml=" + fml + ", gender=" + gender + ", dob=" + dob
				+ ", qualification=" + qualification + ", salary=" + salary + ", email=" + email + ", mobno=" + mobno
				+ ", hiredate=" + hiredate + ", department=" + department + ", ad=" + ad + ", bloodgp=" + bloodgp
				+ ", shift=" + shift + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
