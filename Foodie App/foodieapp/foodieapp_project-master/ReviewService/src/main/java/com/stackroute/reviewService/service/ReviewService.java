package com.stackroute.reviewService.service;


import com.stackroute.reviewService.exception.ReviewAlreadyExistsException;
import com.stackroute.reviewService.exception.ReviewNotFoundException;
import com.stackroute.reviewService.model.Restaurant;
import com.stackroute.reviewService.model.Review;

public interface ReviewService {

	boolean saveReview(int restaurantId,Review review) throws ReviewAlreadyExistsException;
	boolean updateReview(int restaurantId,Review review) throws ReviewAlreadyExistsException,ReviewNotFoundException;
	boolean deleteReview(int restaurantId,Review review) throws ReviewNotFoundException;
	Restaurant getReviewByRestaurantId(int restaurantId) throws ReviewNotFoundException;
	boolean deleteAll(int restaurantId);
}



