package com.stackroute.reviewService.repository;

import org.springframework.stereotype.Repository;

import com.stackroute.reviewService.model.Restaurant;

@Repository
public interface ReviewRepository extends CRUDRepository<Restaurant,Integer> {
	
	

}


