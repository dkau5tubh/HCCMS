package com.seed.beans;

/*this is pojo class*/

public class Medical_History {

	private Syndrome syndrome;

	public Syndrome getSyndrome() {
		return syndrome;
	}

	public void setSyndrome(Syndrome syndrome) {
		this.syndrome = syndrome;
	}

	@Override
	public String toString() {
		return "Medical_History []";
	}

}
