package com.customer.customer.exception;

@SuppressWarnings("serial")
public class NoSuchCustomerExistsException extends RuntimeException{
	
	private String message;
	 
    public NoSuchCustomerExistsException() {}
 
    public NoSuchCustomerExistsException(String msg)
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
