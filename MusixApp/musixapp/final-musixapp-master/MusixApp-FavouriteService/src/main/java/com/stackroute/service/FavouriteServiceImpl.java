package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.exceptions.FavouriteAlreadyExistsException;
import com.stackroute.exceptions.FavouriteNotFoundException;
import com.stackroute.model.Favourite;
import com.stackroute.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	@Autowired
	private final FavouriteRepository favouriteRepo;
	
	public FavouriteServiceImpl(FavouriteRepository favouriteRepo) {
		//write the code;
	}
	
	@Override
	public boolean saveFavourite(Favourite favourite) throws FavouriteAlreadyExistsException {
		
		//write the code
	}
	
	@Override
	public boolean deleteFavourite(String id) throws FavouriteNotFoundException {
		
		//write the code
		
	}

	@Override
	public List<Favourite> getAllfavourites(String loggedInUser) throws FavouriteNotFoundException {
		//write the code
	}
	

	
	

}
