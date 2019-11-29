package com.portal.student.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.portal.student.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
	 public List<Admin> findByUserIdAndUserSeckey(String userId, String userSeckey);
}
