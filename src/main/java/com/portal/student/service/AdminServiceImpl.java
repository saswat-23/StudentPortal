package com.portal.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.student.entity.Student;
import com.portal.student.respository.AdminRepository;
import com.portal.student.respository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public List<Student> getStudentList() {
//		List<Student> studList = (List<Student>) studentRepo.findAll();
//		return studList;
		return
				studentRepo.getAllStudentDataByStatusAndYop("active", 2010);
//		return studentRepo.findByStatus("active");
	}

	@Override
	public void saveStudent(Student student) {

		studentRepo.save(student);	
	}

	@Override
	public void deleteStudent(int id) {
		//studentRepo.deleteById(id);
	}
	
}
