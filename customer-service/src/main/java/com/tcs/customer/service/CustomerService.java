package com.tcs.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.customer.model.Customer;
import com.tcs.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	 private CustomerRepository customerRepository;
	
	/*Begin of Customer Methods */
	public List<Customer> getAllCustomers(){
		List<Customer> customerList= new ArrayList<Customer>();
		customerRepository.findAll().forEach(customerList::add);
		return customerList;
	}
	
	public Customer getCustomer(long id){
	    List<Customer> customerList= new ArrayList<Customer>();
	    Customer customer = null;
	    customerRepository.findAll().forEach(customerList::add);
		try {
			customer = customerList.stream().filter(c->c.getCustomerId()==(id)).findFirst().get();
		}catch(Exception e)
		{
			System.out.println(e);
			customer=null;
		}
		return customer;
	}
	
	public Customer addCustomer(Customer customer){
		customerRepository.save(customer);
		return customer;
	}
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}
}
