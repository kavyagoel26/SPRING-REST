package com.customer.customer.exception;



public class ErrorResponse {
	
	private int statusCode;
    private String message;
 

	public ErrorResponse(int value, String message2) {
		// TODO Auto-generated constructor stub
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
