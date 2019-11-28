package com.portal.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.student.entity.Student;
import com.portal.student.entity.UserProfile;
import com.portal.student.model.LoginRequest;
import com.portal.student.model.LoginResponse;
import com.portal.student.service.SessionService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	SessionService service;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String home() {
		return "Welcome to Admin homepage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		UserProfile admin = new UserProfile(request.getUsername(), request.getPassword());
		LoginResponse response = service.validateAdminLogin(admin);
		return new ResponseEntity<LoginResponse>(response, response.getStatus());
	}
	
	@RequestMapping(value = "/manage/students", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> getStudentList(){
		return new ResponseEntity<List<Student>>(service.getStudentList(), HttpStatus.OK);
	}
}
