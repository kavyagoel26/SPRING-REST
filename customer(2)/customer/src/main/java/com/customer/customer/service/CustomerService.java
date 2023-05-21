package com.customer.customer.service;

import java.util.List;

import com.customer.customer.entity.Customer;

public interface CustomerService {
	
	Customer getCustomer(Long id);
	
    String addCustomer(Customer customer);
 
    String updateCustomer(Customer customer);

	List<Customer> getAllCustomer();
	
	public String deleteCustomer(long parseLong);

	

}
