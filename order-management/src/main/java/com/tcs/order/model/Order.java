package com.tcs.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	@Column(name="ORDERID",unique=true)
	private long orderId;
	@Column(name="CUSTOMERID")
	private long customerId;
	@Column(name="PAYMENTCHANNEL")
	private String paymentChannel;
	@Column(name="ISCOD")
	private Boolean isCod;
	@Column(name="ORDERSTATUS")
	private String orderStatus;
	@Column(name="ORDERCREATEDON")
	private long orderCreatedOn;
	@Column(name="TOTALAMOUNT")
	private double totalAmount;
	@Column(name="SHIPPINGAMOUNT")
	private String shippingAddress;
	
	public Order() {}
	
	public Order(long orderId, long customerId, String paymentChannel, Boolean isCod, String orderStatus,
			long orderCreatedOn, double totalAmount, String shippingAddress) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.paymentChannel = paymentChannel;
		this.isCod = isCod;
		this.orderStatus = orderStatus;
		this.orderCreatedOn = orderCreatedOn;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

	public Boolean getIsCod() {
		return isCod;
	}

	public void setIsCod(Boolean isCod) {
		this.isCod = isCod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getOrderCreatedOn() {
		return orderCreatedOn;
	}

	public void setOrderCreatedOn(long orderCreatedOn) {
		this.orderCreatedOn = orderCreatedOn;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
