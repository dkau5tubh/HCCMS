package com.hccms.beans;

public class Disease {
	private String name,type;
	private Date dateOfOccurence;
	private boolean pathalogyResult;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateOfOccurence() {
		return dateOfOccurence;
	}
	public void setDateOfOccurence(Date dateOfOccurence) {
		this.dateOfOccurence = dateOfOccurence;
	}
	public boolean isPathalogyResult() {
		return pathalogyResult;
	}
	public void setPathalogyResult(boolean pathalogyResult) {
		this.pathalogyResult = pathalogyResult;
	}
	@Override
	public String toString() {
		return "Disease [name=" + name + ", type=" + type + ", dateOfOccurence=" + dateOfOccurence
				+ ", pathalogyResult=" + pathalogyResult + "]";
	}
	
	
}
