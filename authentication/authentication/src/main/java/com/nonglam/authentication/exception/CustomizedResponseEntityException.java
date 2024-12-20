package com.nonglam.authentication.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {Exception.class})
	public final ResponseEntity<Object> handleAll(Exception ex, WebRequest request){
		ErrorDetails errorDetail = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(errorDetail, HttpStatus.NOT_FOUND);
	}
}
