package com.stackroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

import com.stackroute.exceptions.UserNotFoundException;
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
	
	public boolean validateEmailid(String email) {
		return((userRepository.findById(email).isEmpty()));
		}
	
	public boolean isloggedin(String username)
	{
		return (!(userRepository.findByUsername(username).isEmpty()));
		
	}
	public User findUserById(String email) {
		return userRepository.getOne(email);
	}
		public boolean deleteUserProfile(String email)throws UserNotFoundException {
	       if(userRepository.findById(email).isPresent()) {
			userRepository.deleteByEmail(email);
			return true;
	       }else {
	    	   
	    	   return false;
	       }
	}	
		
		
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(String email) throws UserNotFoundException {
		if (userRepository.existsById(email)) {
			User u1 = userRepository.getOne(email);
			return u1;
		} else {
			return null;
		}
	}
	
	public User fetchUserByUsernameAndPassword(String username, String pass) {
		return userRepository.findByUsernameAndPassword(username, pass);
	}
	public boolean validateusername(String username) {
		return ((userRepository.findByUsername(username).isEmpty()));
	}
	
	
	}
	


