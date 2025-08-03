package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex){
		return ResponseEntity.status(HttpStatus.OK).body(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("something went wrong: " + ex.getMessage());
	}
}
