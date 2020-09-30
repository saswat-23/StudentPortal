package com.portal.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.student.entity.Student;
import com.portal.student.model.LoginRequest;
import com.portal.student.model.LoginResponse;
import com.portal.student.service.SessionService;

@CrossOrigin
@RestController
@RequestMapping("/session")
public class SessionController {

	Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	@Autowired
	SessionService service;

	@GetMapping(value = {"","/"})
	public String home() {
		return "Welcome to session homepage";
	}

	@PostMapping(value = "/login", consumes = "application/json")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		Student student = new Student(request.getUsername(), request.getPassword());
		LoginResponse response = service.validateLogin(student);
		return new ResponseEntity<LoginResponse>(response, response.getStatus());
	}

	@PostMapping(value = "/logout")
	public String logout() {
		return "";
	}

}
