package com.hccms.beans;

public class Equipment {
	private int id; //do generic
	private String name,dealerName;
	private Date purchaseDate;
	private double price;
	private int purchaseQuantity,remainedQuantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public int getRemainedQuantity() {
		return remainedQuantity;
	}
	public void setRemainedQuantity(int remainedQuantity) {
		this.remainedQuantity = remainedQuantity;
	}
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", dealerName=" + dealerName + ", purchaseDate="
				+ purchaseDate + ", price=" + price + ", purchaseQuantity=" + purchaseQuantity + ", remainedQuantity="
				+ remainedQuantity + "]";
	}
	
	
	
	
}
