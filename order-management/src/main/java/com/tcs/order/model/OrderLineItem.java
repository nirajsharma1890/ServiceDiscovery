package com.tcs.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderLineItem {
	
	@Id
	@Column(name="ORDERLINEITEMID",unique=true)
	private long orderLineItemId;
	@Column(name="SKUID")
	private long skuId;
	@Column(name="ORDERID")
	private long orderId;
	@Column(name="ITEMQTY")
	private int itemQty;
	
	public OrderLineItem() {}
	public OrderLineItem(long orderLineItemId, long skuId, long orderId, int itemQty) {
		super();
		this.orderLineItemId = orderLineItemId;
		this.skuId = skuId;
		this.orderId = orderId;
		this.itemQty = itemQty;
	}
	public long getOrderLineItemId() {
		return orderLineItemId;
	}
	public void setOrderLineItemId(long orderLineItemId) {
		this.orderLineItemId = orderLineItemId;
	}
	public long getSkuId() {
		return skuId;
	}
	public void setSkuId(long skuId) {
		this.skuId = skuId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
}
