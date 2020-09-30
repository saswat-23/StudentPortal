package com.portal.student.respository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;

import com.portal.student.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
	
	Logger logger = LoggerFactory.getLogger(AdminRepository.class);
	
	public List<Admin> findByUserIdAndUserSeckey(String userId, String userSeckey);
}
