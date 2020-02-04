package com.portal.student.security;

public enum AppUserPermission {
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student_write"),
	COURSE_READ("course_read"),
	COURSE_WRITE("course_write"); 
	
	private final String permission;
	
	private AppUserPermission(String permission) {
		this.permission = permission;	
	}
	
	 
}
