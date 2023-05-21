package com.customer.customer.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.customer.CustomerApplication;
import com.customer.customer.entity.Customer;
import com.customer.customer.exception.CustomerAlreadyExitsException;
import com.customer.customer.exception.ErrorResponse;
import com.customer.customer.service.CustomerService;

@RestController
public class CustomerController {
	    @Autowired 
	    private CustomerService customerService;
	    
	  	static Logger Logger = LogManager.getLogger(CustomerController.class);
	    @GetMapping("/customer")
	    public List<Customer> getAllCustomer() {
	    	Logger.info("Customer Executing ... ");
	    	return this.customerService.getAllCustomer();
	    	
	    	
	    }
	 
	    // Get Customer by Id
	    @GetMapping("/customer/{id}")
	    public Customer getCustomer(@PathVariable("id") Long id)
	    {
	    	Logger.info("Customer get id  ... ");
	        return customerService.getCustomer(id);
	    }
	 
	    // Add new Customer
	    @PostMapping("/customer/new")
	    public String
	    addcustomer(@RequestBody Customer customer)
	    {
	    	Logger.info("Customer added ... ");
	        return customerService.addCustomer(customer);
	    }
	 
	    // Update Customer details
	    @PutMapping("/customer")
	    public String
	    updateCustomer(@RequestBody Customer customer)
	    {
	    	Logger.info("Customer updated ... ");
	        return customerService.updateCustomer(customer);
	    }
	    
	    @ExceptionHandler(value= CustomerAlreadyExitsException.class)
        @ResponseStatus(HttpStatus.CONFLICT)
        public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExitsException ex)
	    {
	    	return new ErrorResponse(HttpStatus.CONFLICT.value(),
                           ex.getMessage());
        }
	    
		@DeleteMapping("/customer/{customerId}")
		public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customerId){
			try {
				this.customerService.deleteCustomer(Long.parseLong(customerId));
				return new ResponseEntity<>(HttpStatus.OK);
			} catch(Exception e) {
				Logger.info("Customer deleted ... ");
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		}

			
		

}
