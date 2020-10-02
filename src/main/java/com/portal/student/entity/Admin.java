package com.portal.student.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "slno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer slno;

	@Column(name = "user_id")
	String userId;

	@Column(name = "user_name")
	String userName;

	@Column(name = "user_seckey")
	String userSeckey;

	@Column(name = "user_email")
	String userEmail;

	@Column(name = "user_contact")
	String userContact;

	@Column(name = "user_status")
	String userStatus;

	@Column(name = "user_pic")
	String userPic;

	@Column(name = "updt_by")
	String updtBy;

	@Column(name = "updt_at")
	Timestamp updtAt;

	public Admin(String userId, String userSeckey) {
		this.userId = userId;
		this.userSeckey = userSeckey;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSeckey() {
		return userSeckey;
	}

	public void setUserSeckey(String userSeckey) {
		this.userSeckey = userSeckey;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUpdtBy() {
		return updtBy;
	}

	public void setUpdtBy(String updtBy) {
		this.updtBy = updtBy;
	}

	public Timestamp getUpdtAt() {
		return updtAt;
	}

	public void setUpdtAt(Timestamp updtAt) {
		this.updtAt = updtAt;
	}
	
	
	
}
