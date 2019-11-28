package com.portal.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
	
	private String username;
	private String password;
	private String userType;
}
