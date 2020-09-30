package com.portal.student.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginRequest {
	
	Logger logger = LoggerFactory.getLogger(LoginRequest.class);

			private String username;
	private String password;
	private String userType;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
