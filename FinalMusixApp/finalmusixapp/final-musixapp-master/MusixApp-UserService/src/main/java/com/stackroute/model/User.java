package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	public User() {

	}

	
	
	
	
	
	
	public User(int id, String email, String username, String password, long mobileno, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.status = status;
	}







	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(length = 30)
	private String email;
	@Column(length = 30)
	private String username;
	@Column(length = 30)
	private String password;
	private long mobileno;
	@Column(length=10,columnDefinition = "boolean default false" )
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public boolean getStatus() {
		return status;
	}







	public void setStatus(boolean status) {
		this.status = status;
	}







	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}







	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", mobileno=" + mobileno + ", status=" + status + "]";
	}


	
}
