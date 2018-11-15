package com.tcs.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.customer.model.Customer;
import com.tcs.customer.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
		
	/*Begin of Customer Endpoints*/
	@GetMapping(value = "/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() throws Exception {
		List<Customer> customerList = this.customerService.getAllCustomers();
		if(customerList.size()==0)
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
		
    }
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id ) throws Exception {
		Customer customer = this.customerService.getCustomer(id);
		if(customer==null)
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer checkCustomer = this.customerService.getCustomer(customer.getCustomerId());
		if(checkCustomer==null) {
			Customer createdCustomer = this.customerService.addCustomer(customer);
			return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);	
		}
		else
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") long id){
		Customer checkCustomer = this.customerService.getCustomer(id);
		if(checkCustomer!=null)
		{
			this.customerService.deleteCustomer(checkCustomer);
			return new ResponseEntity<Customer>(this.customerService.addCustomer(customer),HttpStatus.OK);
		}
		else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
		Customer checkCustomer = this.customerService.getCustomer(id);
	    if(checkCustomer!=null) {
	    	this.customerService.deleteCustomer(checkCustomer);
	    	return new ResponseEntity<Customer>(HttpStatus.OK);
	    }
	    else
	    	return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/customer/")
	public ResponseEntity<Customer> deleteAllCustomers() {
		if(this.customerService.getAllCustomers().size()!=0) {
			this.customerService.deleteAllCustomers();
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);		
	}

}
