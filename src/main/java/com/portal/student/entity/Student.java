package com.portal.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NamedNativeQueries({
	@NamedNativeQuery(name = "Student.getAllStudentData", query = "select * from student where", resultClass = Student.class)
	,
	@NamedNativeQuery(name = "Student.getAllStudentDataByStatusAndYop", query = "select * from student where student.status = ?1 and student.yop>?1", resultClass = Student.class)
})

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String fname;
	private String lname;
	private String password;
	private String email;
	private long phone;
	private String status;
	private int yop;

	public Student(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
