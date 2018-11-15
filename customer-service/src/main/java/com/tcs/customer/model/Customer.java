package com.tcs.customer.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer{
	  @Id
	  @Column(name="CUSTOMERID",unique=true)
	  private long customerId;
	  @Column(name="CUSTOMERNAME")
	  private String customerName;
	  @Column(name="CONTACTNUMBER")
	  private long contactNumber;
	  @Column(name="ADDRESS")
	  private String address;
	  @Column(name="GENDER")
	  private String gender;
	  
	  public Customer() {
	  }
	  
	  public  Customer(long customerId, String customerName, long contactNumber, String address, String gender){
		  this.customerId= customerId;
		  this.customerName= customerName;
		  this.contactNumber= contactNumber;
		  this.address=address;
		  this.gender=gender;
	  }
		  public long getCustomerId() {
			return customerId;
		}
	
		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
	
		public String getCustomerName() {
			return customerName;
		}
	
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
	
		public long getContactNumber() {
			return contactNumber;
		}
	
		public void setContactNumber(long contactNumber) {
			this.contactNumber = contactNumber;
		}
	
		public String getAddress() {
			return address;
		}
	
		public void setAddress(String address) {
			this.address = address;
		}
	
		public String getGender() {
			return gender;
		}
	
		public void setGender(String gender) {
			this.gender = gender;
		}	  
}
