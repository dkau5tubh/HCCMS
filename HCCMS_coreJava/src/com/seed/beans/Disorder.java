package com.seed.beans;

/*this is pojo class*/

public class Disorder {
	private String name, signAndSymptoms, disorderOf;
	private boolean xrayReport, mriReport, otherReport;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignAndSymptoms() {
		return signAndSymptoms;
	}

	public void setSignAndSymptoms(String signAndSymptoms) {
		this.signAndSymptoms = signAndSymptoms;
	}

	public String getDisorderOf() {
		return disorderOf;
	}

	public void setDisorderOf(String disorderOf) {
		this.disorderOf = disorderOf;
	}

	public boolean isXrayReport() {
		return xrayReport;
	}

	public void setXrayReport(boolean xrayReport) {
		this.xrayReport = xrayReport;
	}

	public boolean isMriReport() {
		return mriReport;
	}

	public void setMriReport(boolean mriReport) {
		this.mriReport = mriReport;
	}

	public boolean isOtherReport() {
		return otherReport;
	}

	public void setOtherReport(boolean otherReport) {
		this.otherReport = otherReport;
	}

	public String toString() {
		return "Disorder [name=" + name + ", signAndSymptoms=" + signAndSymptoms + ", disorderOf=" + disorderOf
				+ ", xrayReport=" + xrayReport + ", mriReport=" + mriReport + ", otherReport=" + otherReport + "]";
	}

}
