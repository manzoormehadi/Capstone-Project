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
		this.favouriteRepo = favouriteRepo;
	}
	
	@Override
	public boolean saveFavourite(Favourite favourite) throws FavouriteAlreadyExistsException {
		
		Optional<Favourite> u1 = favouriteRepo.findById(favourite.getId());
		System.out.println("Favorite " + u1.isPresent());
		if(!(u1.isPresent())) {
			Favourite favourite1=favouriteRepo.save(favourite);
			
			return true;

		}
			return false;
	}
	
	@Override
	public boolean deleteFavourite(String id) throws FavouriteNotFoundException {
		
		Optional<Favourite> u1 = favouriteRepo.findById(id);
		if(!(u1.isPresent())) {
			throw new FavouriteNotFoundException("Favourite not found");			
		}
				favouriteRepo.delete(u1.get());
				return true;
		
	}

	@Override
	public List<Favourite> getAllfavourites(String loggedInUser) throws FavouriteNotFoundException {
		List<Favourite> favourite = favouriteRepo.findByUserId(loggedInUser);
		
		if(favourite == null) {
			throw new FavouriteNotFoundException("Favourite not found");
		}
		else
		return favourite;
	}
	

	
	

}
