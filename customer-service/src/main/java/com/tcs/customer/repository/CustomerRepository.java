package com.tcs.customer.repository;
import org.springframework.data.repository.CrudRepository;

import com.tcs.customer.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}
