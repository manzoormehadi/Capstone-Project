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
		System.out.println("Favorite id: "+favourite.getId());
		System.out.println("LoggedINuser "+favourite.getLoggedInUser());
		
		try {
			favouriteService.saveFavourite(favourite);
			return new ResponseEntity<String>("Favourite added successfully", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("{\"message\": \""+e.getMessage()+"\"}", HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFavourie(@PathVariable(value="id") String id){
		try {
			favouriteService.deleteFavourite(id);
			return new ResponseEntity<String>("Favourite deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("{\"message\": \""+e.getMessage()+"\"}", HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/getAllFavourites/{loginUser}")
	public ResponseEntity<?> getAllFavourites(@PathVariable(value="loginUser") String loginUser){
		System.out.println("LoggedINuser "+loginUser);
		try {
			List<Favourite> favourites = favouriteService.getAllfavourites(loginUser);
			if(favourites == null) {
				throw new Exception("Favourites not available");
			}
			return new ResponseEntity<List<Favourite>>(favourites, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("{\"message\": \""+e.getMessage()+"\"}", HttpStatus.UNAUTHORIZED);
		}
	}
	
}