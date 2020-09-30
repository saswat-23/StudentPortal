package com.portal.student.service;

import java.util.List;

import com.portal.student.entity.Student;

public interface AdminService {
	
	public List<Student> getStudentList();
	public void saveStudent(Student student);
	public void deleteStudent(int id);
}
