package com.portal.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.student.entity.Admin;
import com.portal.student.entity.Student;
import com.portal.student.exception.UserNotFoundException;
import com.portal.student.model.LoginRequest;
import com.portal.student.model.LoginResponse;
import com.portal.student.service.AdminService;
import com.portal.student.service.SessionService;

@CrossOrigin
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SessionService sessionService;
	@Autowired
	AdminService adminService;
	

	@GetMapping(value = { "", "/" })
	public String home() {
		return "Welcome to Admin homepage";
	}

	@PostMapping(value = "/login", consumes = "application/json")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		Admin admin = new Admin(request.getUsername(), request.getPassword());
		LoginResponse response = sessionService.validateAdminLogin(admin);
		return new ResponseEntity<LoginResponse>(response, response.getStatus());
	}

	@GetMapping(value = "/manage/students", produces = "application/json")
	public ResponseEntity<List<Student>> getStudentList() {
		
		List<Student> studentList = adminService.getStudentList();
		logger.debug("The List is: "+studentList);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/manage/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		adminService.saveStudent(student);
		return new ResponseEntity<Object>("Student data added.", HttpStatus.OK);
	}
	
	@PutMapping(value = "/manage/student/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		
		if(id==0) {
			throw new UserNotFoundException();
		}
		
		adminService.saveStudent(student);
		return new ResponseEntity<String>("Details updated successfully!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/manage/student/{id}")
	public ResponseEntity<?> removeStudent(@PathVariable("id") int id) {
		adminService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
	
}
