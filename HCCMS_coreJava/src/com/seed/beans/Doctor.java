package com.seed.beans;

/*this is pojo class*/

public class Doctor {
	private String specialisation, fees, testName;

	/*
	 * public Doctor(String specialisation, String fees, String testName) { super();
	 * this.specialisation = specialisation; this.fees = fees; this.testName =
	 * testName; }
	 */

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Doctor [specialisation=" + specialisation + ", fees=" + fees + ", testName=" + testName + "]";
	}

}
