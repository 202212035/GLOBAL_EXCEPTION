package com.abc.response;

public class ApiResponse 
{
	String message;
	Boolean success;
	
	public ApiResponse() {		super();	}
	
	public ApiResponse(String message, Boolean success)
	{
		super();
		this.message = message;
		this.success = success;
	}
	
	public String getMessage() {		return message;	}
	public void setMessage(String message) {		this.message = message;	}
	public Boolean getSuccess() {		return success;	}
	public void setSuccess(Boolean success) {		this.success = success;	}
	
}