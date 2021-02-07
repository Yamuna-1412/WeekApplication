package com.week3Challenge.ExceptionHandle;



public class ExceptionResponse {
	private String ErrorMessage;
	private String details;
	
	public ExceptionResponse(String message, String description) {

	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
