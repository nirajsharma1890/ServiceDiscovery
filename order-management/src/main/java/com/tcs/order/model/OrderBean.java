package com.tcs.order.model;

public class OrderBean {
	
	private long orderId;
	private long customerId;
	private String paymentChannel;
	private long skuId;
	private int itemQty;
	private double totalAmount;
	private String shippingAddress;
	public OrderBean() {}
	
	
	

	public OrderBean(long orderId, long customerId, String paymentChannel, long skuId, int itemQty,
			double totalAmount,String shippingAddress) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.paymentChannel = paymentChannel;
		this.skuId = skuId;
		this.itemQty = itemQty;
		this.totalAmount = totalAmount;
		this.shippingAddress=shippingAddress;
	}

	
	
	public String getShippingAddress() {
		return shippingAddress;
	}




	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}




	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	public long getSkuId() {
		return skuId;
	}
	public void setSkuId(long skuId) {
		this.skuId = skuId;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

}
