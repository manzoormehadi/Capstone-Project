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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stackroute.model.Favourite;
import com.stackroute.service.FavouriteService;

@RestController
@RequestMapping("/api/v1/favouriteservice")
@CrossOrigin("*")
public class FavouriteController {

	@Autowired
	private FavouriteService favouriteService;
	
	@PostMapping
	public ResponseEntity<?> registerFavourie(@RequestBody Favourite favourite){
		//write the code
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFavourie(@PathVariable(value="id") String id){
		//write the code
	}
	
	@GetMapping("/getAllFavourites/{loginUser}")
	public ResponseEntity<?> getAllFavourites(@PathVariable(value="loginUser") String loginUser){
		//write the code
	}
	
}
