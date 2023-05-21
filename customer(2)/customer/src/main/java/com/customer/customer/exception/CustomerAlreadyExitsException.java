package com.customer.customer.exception;

@SuppressWarnings("serial")
public class CustomerAlreadyExitsException extends RuntimeException {
	private String message;
	
	public CustomerAlreadyExitsException() {
	}
	
	 public CustomerAlreadyExitsException(String msg)
	    {
	        super(msg);
	        this.setMessage(msg);
	    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
