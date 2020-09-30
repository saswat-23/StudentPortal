package com.portal.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
			
	//@GetMapping(value = {"/",""})
	public String home() {
		return "Welcome to Student Portal!";
	}
}
