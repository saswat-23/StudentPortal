package com.portal.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.portal.student.entity.Student;
import com.portal.student.entity.Admin;
import com.portal.student.model.LoginResponse;
import com.portal.student.respository.AdminRepository;
import com.portal.student.respository.StudentRepository;

@Service
public class SessionService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	LoginResponse loginResponse;
	
	public LoginResponse validateLogin(Student student) {
		System.out.println("Student Details received: "+student);
		List<Student> studList = studentRepo.findByUsernameAndPassword(student.getUsername(), student.getPassword());
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

	public LoginResponse validateAdminLogin(Admin admin) {
		System.out.println("Admin Details received: "+admin);
		List<Admin> adminList = adminRepo.findByUserIdAndUserSeckey(admin.getUserId(), admin.getUserSeckey());
		System.out.println(adminList);
		admin = adminList.size() > 0? adminList.get(0):null;
		
		loginResponse = new LoginResponse();
		
		if(admin == null) {
			loginResponse.setValid(false);
			loginResponse.setMessage("Invalid login credentials!");
			loginResponse.setStatus(HttpStatus.UNAUTHORIZED);
		}
		else
		{
			loginResponse.setValid(true);
			loginResponse.setFname(admin.getUserName().split(" ")[0]);
			loginResponse.setLname(admin.getUserName().split(" ")[1]);
			loginResponse.setUsername(admin.getUserName());
			loginResponse.setStatus(HttpStatus.ACCEPTED);
		}
		
		return loginResponse;
	}

}
