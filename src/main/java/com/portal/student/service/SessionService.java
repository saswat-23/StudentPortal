package com.portal.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.portal.student.entity.Admin;
import com.portal.student.entity.Student;
import com.portal.student.model.LoginResponse;

public interface SessionService {
	
	Logger logger = LoggerFactory.getLogger(SessionService.class);
	
	public LoginResponse validateLogin(Student student);
	public LoginResponse validateAdminLogin(Admin admin);
}
