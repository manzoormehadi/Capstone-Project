package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.exception.FavouriteAlredyExistsException;
import com.stackroute.exception.FavouriteNotFoundException;
import com.stackroute.model.Favourite;
import com.stackroute.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService
{
	@Autowired
	private final FavouriteRepository favrepo;
	
	public FavouriteServiceImpl(FavouriteRepository favrepo) {
		this.favrepo = favrepo;
	}
	
/*	@Override
	public boolean saveFavourite(Favourite favourite) throws FavouriteAlredyExistsException {
		
		
		Optional<Favourite> u1 = favrepo.findById(favourite.getRestaurantId());
		System.out.println("Favorite " + u1.isPresent());
		if(!(u1.isPresent())) {
			favrepo.save(favourite);
			return true;

		}
			return false;
	}*/

	@Override
	public boolean saveFavourite(Favourite favourite) {
		
			favrepo.save(favourite);
			return true;
			
	}
	

	@Override
	public boolean validateID(int restaurantId) {
		
		return (favrepo.findById(restaurantId).isEmpty());
	}
	
	
	
	@Override
	public boolean deleteFavourite(int restaurantId) throws FavouriteNotFoundException 
	{
		Optional<Favourite> u1 = favrepo.findById(restaurantId);
		
		if(u1.isPresent())
		{
			System.out.println("123"+u1);
			favrepo.deleteById(restaurantId);
			return true;
		}
		else
			return false;
	}
	
	
	
	@Override
	public List<Favourite> getAllfavourites(String loggedInUser) throws FavouriteNotFoundException {
		List<Favourite> favourite = favrepo.findByUserId(loggedInUser);
		System.out.println(favourite);
		if(favourite.isEmpty()) {
			throw new FavouriteNotFoundException("Favourite not found");
		}
		else
		return favourite;
	}

	@Override
	public Favourite getfavourite(int restaurantId) throws FavouriteNotFoundException {
		if(favrepo.findById(restaurantId).isPresent())
		{
			Favourite u1 = favrepo.getOne(restaurantId);
			return u1;
		}
		else
		{
			throw new FavouriteNotFoundException("Favourite not found");
		}
	}



}
