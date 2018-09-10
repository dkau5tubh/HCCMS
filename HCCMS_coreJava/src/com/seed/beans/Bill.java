package com.seed.beans;
//This is Pojo 
public class Bill<T> {
	private t id; // do generic
	private String name;
	private double amount, totalBill;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", name=" + name + ", amount=" + amount + ", totalBill=" + totalBill + "]";
	}

}
