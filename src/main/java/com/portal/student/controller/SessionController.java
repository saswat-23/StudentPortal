package com.portal.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/session")
public class SessionController {
	
	
	@RequestMapping("/")
	public String home() {
		return "Welcome to homepage";
	}
	
	@RequestMapping("/login")
	public void login() {
		
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "";
	}
	
}
