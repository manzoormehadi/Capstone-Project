package com.stackroute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stackroute.model.Recommend;

public interface RecommendRepository extends JpaRepository<Recommend, String> {
	
	
	@Query("select u from Recommend u where loggedInUser= :loggedInUser")
	public List<Recommend> findbyUserId(@Param("loggedInUser") String loggedInUser);
	
}