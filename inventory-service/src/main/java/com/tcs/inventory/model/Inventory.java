package com.tcs.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	@Column(name="SKUID")
	long skuId;
	@Column(name="PRODUCTNAME")
	String productName;
	@Column(name="PRODUCTLABEL")
	String productLabel;
	@Column(name="INVENTORYONHAND")
	int inventoryOnHand;
	@Column(name="MINQTYREQ")
	int minQtyReq;
	@Column(name="PRICE")
	double price;
	
	public Inventory(){
	}
	
	public Inventory(long skuId, String productName, String productLabel, int inventoryOnHand, int minQtyReq, double price) {
		this.skuId=skuId;
		this.productName=productName;
		this.productLabel=productLabel;
		this.inventoryOnHand=inventoryOnHand;
		this.minQtyReq=minQtyReq;
		this.price=price;
	}

	public long getSkuId() {
		return skuId;
	}

	public void setSkuId(long skuId) {
		this.skuId = skuId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public void setProductLabel(String productLabel) {
		this.productLabel = productLabel;
	}

	public int getInventoryOnHand() {
		return inventoryOnHand;
	}

	public void setInventoryOnHand(int inventoryOnHand) {
		this.inventoryOnHand = inventoryOnHand;
	}

	public int getMinQtyReq() {
		return minQtyReq;
	}

	public void setMinQtyReq(int minQtyReq) {
		this.minQtyReq = minQtyReq;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
