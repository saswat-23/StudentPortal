package com.portal.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.portal.student.entity.Student;
import com.portal.student.model.LoginResponse;
import com.portal.student.respository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	SessionRepository repository;
	LoginResponse loginResponse;
	
	public LoginResponse validateLogin(Student student) {
		System.out.println("Student Details received: "+student);
		List<Student> studList = repository.findByUsernameAndPassword(student.getUsername(), student.getPassword());
		System.out.println(studList);
		student = studList.size() > 0? studList.get(0):null;
		
		loginResponse = new LoginResponse();
		
		if(student == null) {
			loginResponse.setValid(false);
			loginResponse.setMessage("Invalid Credentials provided!");
			loginResponse.setStatus(HttpStatus.UNAUTHORIZED);
		}
		else
		{
			loginResponse.setValid(true);
			loginResponse.setFname(student.getFname());
			loginResponse.setLname(student.getLname());
			loginResponse.setUsername(student.getUsername());
			loginResponse.setStatus(HttpStatus.ACCEPTED);
		}
		
		return loginResponse;
	}
	
}
