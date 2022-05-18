package com.stackroute.service;

import java.util.List;

import com.stackroute.exception.FavouriteAlredyExistsException;
import com.stackroute.exception.FavouriteNotFoundException;
import com.stackroute.model.Favourite;

public interface FavouriteService {

	boolean saveFavourite(Favourite favourite) throws FavouriteAlredyExistsException;

	boolean validateID(int restaurantId);
	
	boolean deleteFavourite(int favId) throws FavouriteNotFoundException;
	
	public List<Favourite> getAllfavourites(String loggedInUser) throws FavouriteNotFoundException;

	public Favourite getfavourite(int restaurantId) throws FavouriteNotFoundException;

	
	
	
}
