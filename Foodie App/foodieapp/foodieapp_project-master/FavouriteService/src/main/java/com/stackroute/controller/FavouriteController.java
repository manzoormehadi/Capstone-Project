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

import com.stackroute.exception.FavouriteAlredyExistsException;
import com.stackroute.exception.FavouriteNotFoundException;
import com.stackroute.model.Favourite;
import com.stackroute.service.FavouriteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/favouriteservice")
public class FavouriteController {
	
	@Autowired
	private FavouriteService favouriteService;
	

	@PostMapping("/addfav")
	public ResponseEntity<?> registerFavourie(@RequestBody Favourite favourite) throws FavouriteAlredyExistsException{
		System.out.println("Favorite id: "+favourite.getFavId());
		System.out.println("LoggedINuser "+favourite.getLoggedInUser());
		
		
		if(favouriteService.validateID(favourite.getRestaurantId())) {
			favouriteService.saveFavourite(favourite);
			return new ResponseEntity<>(favourite, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Favorite already exist", HttpStatus.CONFLICT);
		}
	}

	
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<String> deleteFavourite(@PathVariable(value="restaurantId") int restaurantId) throws FavouriteNotFoundException
	{
		
		try {
		if(favouriteService.deleteFavourite(restaurantId))
		{
			
		return new ResponseEntity<>("Favourite deleted successfully", HttpStatus.OK);
		}
		
		}catch(FavouriteNotFoundException e)
		
		{
			return new ResponseEntity<>("Favourite Not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Favourite Not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAllFavourites/{loginUser}")
	public ResponseEntity<?> getAllFavourites(@PathVariable(value="loginUser") String loginUser){
		System.out.println("LoggedINuser "+loginUser);
		try {
			List<Favourite> favourites = favouriteService.getAllfavourites(loginUser);
			if(favourites.isEmpty()) {
				throw new Exception("Favourites not available");
			}
			else
			{
			return new ResponseEntity<List<Favourite>>(favourites, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<String>("Favourite not found", HttpStatus.CONFLICT);
		}
		
	}
	
	
	
}
