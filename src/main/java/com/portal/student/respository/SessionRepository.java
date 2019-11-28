  package com.portal.student.respository;
  
  import java.util.List;

import org.springframework.data.repository.CrudRepository;
  import org.springframework.stereotype.Repository;

import com.portal.student.entity.Student;
  
  @Repository
  public interface SessionRepository extends CrudRepository<Student, String> {
	  
	  public List<Student> findByUsernameAndPassword(String username, String password);
  }
 