package com.abc.exception;

public class BadRequestException extends RuntimeException
{
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public BadRequestException() {		super();	}
	
	public BadRequestException(String resourceName, String fieldName, long fieldValue)
	{
		super(String.format("%s Bad Request %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {		return resourceName;	}
	public void setResourceName(String resourceName) {		this.resourceName = resourceName;	}
	public String getFieldName() {		return fieldName;	}
	public void setFieldName(String fieldName) {		this.fieldName = fieldName;	}
	public long getFieldValue() {		return fieldValue;	}
	public void setFieldValue(long fieldValue) {		this.fieldValue = fieldValue;	}
}