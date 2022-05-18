package com.stackroute.service;

import java.util.List;

import com.stackroute.exceptions.FavouriteAlreadyExistsException;
import com.stackroute.exceptions.FavouriteNotFoundException;
import com.stackroute.model.Favourite;

public interface FavouriteService {
	
	boolean saveFavourite(Favourite favourite) throws FavouriteAlreadyExistsException;
	
	boolean deleteFavourite(String id) throws FavouriteNotFoundException;
	
	public List<Favourite> getAllfavourites(String loggedInUser) throws FavouriteNotFoundException;
	
	
}
