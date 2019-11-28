package com.portal.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.student.entity.Student;
import com.portal.student.model.LoginRequest;
import com.portal.student.model.LoginResponse;
import com.portal.student.service.SessionService;
@RestController
@RequestMapping("/session")
public class SessionController {
	
	@Autowired
	SessionService service;
//	@Autowired
//	Student student;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Welcome to homepage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		Student student = new Student(request.getUsername(), request.getPassword());
		LoginResponse response = service.validateLogin(student);
		return new ResponseEntity<LoginResponse>(response, response.getStatus());
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		return "";
	}
	
}
