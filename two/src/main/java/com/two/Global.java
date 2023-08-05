package com.two;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abc.exception.ResourceNotFoundException;

@ControllerAdvice
public class Global 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception)
	{
		String message = exception.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
//
//public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception)	{
//	String message = exception.getMessage();
//	ApiResponse apiResponse = new ApiResponse(message,false);
//	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);	}
