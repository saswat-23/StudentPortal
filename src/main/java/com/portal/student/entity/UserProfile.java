package com.portal.student.entity;

import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name="user_profile")
@Data @NoArgsConstructor
public class UserProfile{

  @Id
  @Column(name="slno")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer slno;

  @Column(name="user_id" )
  String userId;

  @Column(name="user_name" )
  String userName;

  @Column(name="user_seckey" )
  String userSeckey;

  @Column(name="user_email" )
  String userEmail;

  @Column(name="user_contact" )
  String userContact;

  @Column(name="user_status" )
  String userStatus;

  @Column(name="user_pic" )
  String userPic;

  @Column(name="updt_by" )
  String updtBy;

  @Column(name="updt_at" )
  Timestamp updtAt;

  public UserProfile(String userId, String userSeckey) {
	this.userId = userId;
	this.userSeckey = userSeckey;
  }

  
}
