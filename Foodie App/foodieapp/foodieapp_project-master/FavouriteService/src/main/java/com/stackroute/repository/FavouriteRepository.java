package com.stackroute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.model.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Integer> {

	@Query("select u from Favourite u where loggedInUser= :loggedInUser")
	public List<Favourite> findByUserId(@Param("loggedInUser") String loggedInUser);

//	public Optional<Favourite> findById(int restaurantId);
}
