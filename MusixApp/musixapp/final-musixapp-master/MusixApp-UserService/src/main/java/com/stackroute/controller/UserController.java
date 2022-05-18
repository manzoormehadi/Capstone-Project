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
		//write the code
	}

	@PutMapping("/api/v1/user/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		//write the code
	}

	@PutMapping("/api/v1/user/logout")
	public ResponseEntity<?> logout(@RequestBody User user) {
		//write the code
	}

}
