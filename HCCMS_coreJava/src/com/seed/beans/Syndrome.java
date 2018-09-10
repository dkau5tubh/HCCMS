package com.seed.beans;

/*this is pojo class*/

public class Syndrome {

	private Date dateOfOccurance;

	public Date getDateOfOccurance() {
		return dateOfOccurance;
	}

	public void setDateOfOccurance(Date dateOfOccurance) {
		this.dateOfOccurance = dateOfOccurance;
	}

	@Override
	public String toString() {
		return "Syndrome [dateOfOccurance=" + dateOfOccurance + "]";
	}

}
