package com.portal.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.portal.student.exception.UserNotFoundException;

@ControllerAdvice
public class AdminExceptionController {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception (UserNotFoundException unfException){
		return new ResponseEntity<Object>("User Not Found!", HttpStatus.NOT_FOUND);
	}
	
}
