package com.portal.student.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.portal.student.entity.Student;

public interface AdminService {
	
	Logger logger = LoggerFactory.getLogger(AdminService.class);
	
	public List<Student> getStudentList();
	public void saveStudent(Student student);
	public void deleteStudent(int id);
}
