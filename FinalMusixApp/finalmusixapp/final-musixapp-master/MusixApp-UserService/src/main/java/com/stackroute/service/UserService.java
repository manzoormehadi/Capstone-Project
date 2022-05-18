package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.model.User;
import com.stackroute.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	

	public boolean addUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	
		return true;
		
	}
	

	
	public boolean validate(String username, String password) {
		return (!(userRepository.findByUsernameAndPassword(username, password).isEmpty()));
	}
	
	public boolean validateemailid(String email) {
	return((userRepository.findByEmail(email).isEmpty()));
	}
	
	public boolean isloggedin(String username)
	{
		return (!(userRepository.findByUsername(username).isEmpty()));
		
	}
	
	
	
	
	

}
