package com.tcs.vendor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {

	@Id
	@Column(name="VENDORID")
	long vendorId;
	@Column(name="VENDORNAME")
	String vendorName;
	@Column(name="VENDORCONTACTNO")
	long vendorContactNo;
	@Column(name="VENDOREMAIL")
	String vendorEmail;
	@Column(name="VENDORUSERNAME")
	String vendorUsername;
	@Column(name="VENDORADDRESS")
	String vendorAddress;
	
	 public Vendor() {
	  }
	
	public Vendor(long vendorId, String vendorName, long vendorContactNo, String vendorEmail, String vendorUsername, String vendorAddress)
	{
		this.vendorId=vendorId;
		this.vendorName=vendorName;
		this.vendorContactNo=vendorContactNo;
		this.vendorEmail=vendorEmail;
		this.vendorUsername=vendorUsername;
		this.vendorAddress=vendorAddress;
	}
	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public long getVendorContactNo() {
		return vendorContactNo;
	}
	public void setVendorContactNo(long vendorContactNo) {
		this.vendorContactNo = vendorContactNo;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorUsername() {
		return vendorUsername;
	}
	public void setVendorUsername(String vendorUsername) {
		this.vendorUsername = vendorUsername;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	
	
}
