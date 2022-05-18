package com.stackroute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stackroute.model.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, String> {
	
	
	@Query("select u from Favourite u where loggedInUser= :loggedInUser")
	public List<Favourite> findByUserId(@Param("loggedInUser") String loggedInUser);
	
}
