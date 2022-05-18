package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.exceptions.UserNotFoundException;
import com.stackroute.model.User;

import com.stackroute.service.UserService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserService userService;
	
	//Adding an new user
	@PostMapping(value = "/api/v1/user/adduser")
	
	public ResponseEntity<?> addUser(@RequestBody User user) {
	if (userService.validateEmailid(user.getEmail()) && userService.validateusername(user.getUsername())) {
		userService.addUser(user);
		return new ResponseEntity<>("New User added", HttpStatus.CREATED);
	} else if (!userService.validateEmailid(user.getEmail())) {
		return new ResponseEntity<>("Registraion with this emailID already exits", HttpStatus.CONFLICT);
	} else
		return new ResponseEntity<>("Username already exits", HttpStatus.CONFLICT);
	}

	//Sign in 
	
	
	@PutMapping("/api/v1/user/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		String tempUsername = user.getUsername();
		String tempPassword = user.getPassword();
		
		User userobj = userService.fetchUserByUsernameAndPassword(tempUsername, tempPassword);
			if (userobj!=null) {
				if(!userobj.isStatus()) {
				userobj.setStatus(true);
				userService.addUser(userobj);
				return new ResponseEntity<>(userobj, HttpStatus.OK);
			}
			else {
				
				return new ResponseEntity<>("User logged ", HttpStatus.CONFLICT);
			}
		}
		else {
			return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
		}
		
	}
	//Sign out
	@PutMapping("/api/v1/user/logout")
	public ResponseEntity<?> logout(@RequestBody User user) {
		System.out.println(user.getEmail());
		
		User userobj = userService.fetchUserByUsernameAndPassword(user.getUsername(), user.getPassword());

		if (userobj.isStatus()) {
			userobj.setStatus(false);
			userService.addUser(userobj);
			System.out.println("qwert");
			return new ResponseEntity<>("User logged out ", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not logged out", HttpStatus.CONFLICT);
		}
	}
	//Deleting an existing user
	@DeleteMapping(value="/api/v1/user/{email}")
	public ResponseEntity<String> deleteUserProfile(@PathVariable("email") String email) throws UserNotFoundException  {
	    if(userService.getUser(email)!=null) {
		userService. deleteUserProfile(email);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
		
	}else {
		
		return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		
	}
	   }	
	 @GetMapping("/api/v1/user")
		public ResponseEntity<List<User>> getAllUser() {
			return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	    }	
	 
	 @GetMapping(value = "/api/v1/user/{email}")
		public ResponseEntity<?> getUserbyId(@PathVariable("email") String email) throws UserNotFoundException {
			if (userService.getUser(email) != null) {
				return new ResponseEntity<User>(userService.getUser(email), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Not found!!", HttpStatus.NOT_FOUND);
             }
}
}