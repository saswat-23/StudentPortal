package com.portal.student.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.portal.student.entity.UserProfile;

public interface AdminRepository extends CrudRepository<UserProfile, String> {
	 public List<UserProfile> findByUserIdAndUserSeckey(String userId, String userSeckey);
}
