package com.customer.customer.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customer.entity.Customer;
import com.customer.customer.exception.CustomerAlreadyExitsException;
import com.customer.customer.exception.NoSuchCustomerExistsException;
import com.customer.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	 @Autowired
	    private CustomerRepository customerRespository;
	 
	 
	 
		public List<Customer> getAllCustomer() {
			return customerRespository.findAll();
	 }
	 
	 
	 public Customer getCustomer(Long id)
	    {
	        return customerRespository.findById(id).orElseThrow(
	            ()-> new NoSuchElementException(
	                    "NO CUSTOMER PRESENT WITH ID = " + id));
	    }
	 
	 
	 public String addCustomer(Customer customer)
	    {
	        Customer existingCustomer
	            = customerRespository.findById(customer.getId())
	                  .orElse(null);
	        if (existingCustomer == null) {
	            customerRespository.save(customer);
	            return "Customer added successfully";
	        }
	        else
	            throw new CustomerAlreadyExitsException("Customer already exists!!");
	    }

	 
	 public String updateCustomer(Customer customer)
	    {
	        Customer existingCustomer= customerRespository.findById(customer.getId()).orElse(null);
	        if (existingCustomer == null)
	            throw new NoSuchCustomerExistsException("No Such Customer exists!!");
	        else {
	            existingCustomer.setName(customer.getName());
	            existingCustomer.setAddress( customer.getAddress());
	            customerRespository.save(existingCustomer);
	            return "Record updated Successfully";
	        }
	    }
	 public String deleteCustomer(long parseLong)
	 {
		 customerRespository.deleteById(parseLong);
		return "Deleted!!";
	
	 }





	




	
}
