package com.portal.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Entity
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String fname;
	private String lname;
	private String password;
	
	public Student(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
