  package com.portal.student.respository;
  
  import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portal.student.entity.Student;
  
  @Repository
  public interface StudentRepository extends CrudRepository<Student, String> {
	  
	  Logger logger = LoggerFactory.getLogger(StudentRepository.class);
	  
	  public List<Student> findByUsernameAndPassword(String username, String password);
	  
	  //@Query(value="select s from Student s where s.status = 'inactive'")
	  @Query(value="select * from student s where s.status = 'inactive'", nativeQuery = true)
	  public List<Student> findByStatus(String status);
	  
	  //@Query(value = "select s from Student s where s.status = ?1 and s.yop>?2")	s.username, s.fname, s.lname, s.email, s.phone
	  @Query(value = "select * from student s where s.status = ?1 and s.yop>?2", nativeQuery = true)
	  public List<Student> getAllStudentDataByStatusAndYop(String status, int yop);
	  
  }
 