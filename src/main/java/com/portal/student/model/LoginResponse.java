package com.portal.student.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginResponse {
	
	boolean isValid;
	String message;
	String username;
	String fname;
	String lname;
	HttpStatus status;
}
