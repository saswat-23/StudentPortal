package com.portal.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.student.entity.Student;
import com.portal.student.respository.AdminRepository;
import com.portal.student.respository.StudentRepository;

@Service
public class AdminService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	public List<Student> getStudentList() {
		List<Student> studList = (List<Student>) studentRepo.findAll();
		return studList;
	}

	public void saveStudent(Student student) {

		studentRepo.save(student);	
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		//studentRepo.deleteById(id);
	}
	
}
