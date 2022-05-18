package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.User;
import com.stackroute.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/api/v1/user/adduser")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		System.out.println(userService.validateemailid(user.getEmail()));
		if (userService.validateemailid(user.getEmail())){
			userService.addUser(user);
			return new ResponseEntity<>("New User added", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Registraion with this emailID already exits", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/api/v1/user/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		if (userService.validate(user.getUsername(), user.getPassword())) {
			user.setStatus(true);
			// userService.addUser(user);
			return new ResponseEntity<>("User logged in", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("User not authorized", HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/api/v1/user/logout")
	public ResponseEntity<?> logout(@RequestBody User user) {
		if (userService.isloggedin(user.getUsername())) {
			user.setStatus(false);
			// userService.addUser(user);
			return new ResponseEntity<>("User logged out ", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("User not logged out", HttpStatus.CONFLICT);
		}
	}

}
