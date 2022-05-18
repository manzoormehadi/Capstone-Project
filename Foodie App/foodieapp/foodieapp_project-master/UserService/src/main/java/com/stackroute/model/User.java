package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;



@Entity
public class User {
	
	
	@Id
	@Column(length = 50, nullable=false)
	private String email;
	@Column(length = 30, nullable=false)
	@NotEmpty(message="phoneno should not be empty")
	private String mobileno;
	@Column(length = 30,nullable=false)
	private String password;
	@Column(length=10,columnDefinition = "boolean default false",nullable=false )
	private boolean status;
	@Column(length = 30,nullable=false)
	private String username;
	
	
	
	
	public User() {

	}
	
	public User(String email, String mobileno, String password, boolean status, String username) {
		super();
		this.email = email;
		this.mobileno = mobileno;
		this.password = password;
		this.status = status;
		this.username = username;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
   
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

}
