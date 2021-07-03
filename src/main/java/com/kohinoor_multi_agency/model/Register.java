package com.kohinoor_multi_agency.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Register {
@Id
private int userID;
private String emailId;
private String userName;
private String password;

public Register(int userID, String emailId, String userName, String password) {
	super();
	this.userID = userID;
	this.emailId = emailId;
	this.userName = userName;
	this.password = password;
}

public Register() {
}

public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
