package com.seed.beans;

/*this is Pojo*/

public class Department<T> {
	public T id;
	private String deptname;
	private int phoneNumber;

	// parametric constructor
	/*
	 * public Department(int id, String deptname, int phoneNumber) { super();
	 * this.id = id; this.deptname = deptname; this.phoneNumber = phoneNumber; }
	 */
	// getter and setter methods
	public t getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "deaprtment [id=" + id + ", deptname=" + deptname + ", phoneNumber=" + phoneNumber + "]";
	}

}
