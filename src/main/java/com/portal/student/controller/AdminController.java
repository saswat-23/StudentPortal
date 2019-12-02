package com.portal.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.student.entity.Student;
import com.portal.student.entity.Admin;
import com.portal.student.model.LoginRequest;
import com.portal.student.model.LoginResponse;
import com.portal.student.service.AdminService;
import com.portal.student.service.SessionService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	SessionService sessionService;
	@Autowired
	AdminService adminService;
	

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String home() {
		return "Welcome to Admin homepage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		Admin admin = new Admin(request.getUsername(), request.getPassword());
		LoginResponse response = sessionService.validateAdminLogin(admin);
		return new ResponseEntity<LoginResponse>(response, response.getStatus());
	}

	@RequestMapping(value = "/manage/students", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> getStudentList() {
		return new ResponseEntity<List<Student>>(adminService.getStudentList(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/manage/student", method = RequestMethod.POST)
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		adminService.saveStudent(student);
		return new ResponseEntity<Object>("Student data added.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/manage/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		adminService.saveStudent(student);
		return new ResponseEntity<String>("Details updated successfully!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/manage/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> updateStudent(@PathVariable("id") int id) {
		adminService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
	
}
