package com.portal.student.service;

import com.portal.student.entity.Admin;
import com.portal.student.entity.Student;
import com.portal.student.model.LoginResponse;

public interface SessionService {
	
	public LoginResponse validateLogin(Student student);
	public LoginResponse validateAdminLogin(Admin admin);
}
