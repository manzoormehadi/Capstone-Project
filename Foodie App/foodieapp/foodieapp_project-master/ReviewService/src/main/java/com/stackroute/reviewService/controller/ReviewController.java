package com.stackroute.reviewService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.reviewService.exception.ReviewAlreadyExistsException;
import com.stackroute.reviewService.exception.ReviewNotFoundException;
import com.stackroute.reviewService.model.Restaurant;
import com.stackroute.reviewService.model.Review;
import com.stackroute.reviewService.service.ReviewService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	
	String reviewnotfound="Review not found";
	@PostMapping("/addreview/{restaurantId}")
	public ResponseEntity<String> addReview(@PathVariable("restaurantId") int restaurantId, @RequestBody Review review) throws ReviewAlreadyExistsException{
		
		if(reviewService.saveReview(restaurantId ,review)) {
			return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Review already exist", HttpStatus.CONFLICT);
		}
	
	}
	
	@GetMapping(value = "/{restaurantId}")
	public ResponseEntity<?> getRestaurantByRestaurantId(@PathVariable("restaurantId") int restaurantId) throws ReviewNotFoundException {
		Restaurant restaurant;

		if ((restaurant = reviewService.getReviewByRestaurantId(restaurantId)) != null) {
			return new ResponseEntity<>(restaurant, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(reviewnotfound, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/updatereview/{restaurantId}")
	public ResponseEntity<String> updateReview(@PathVariable("restaurantId") int restaurantId, @RequestBody Review review) throws ReviewNotFoundException, ReviewAlreadyExistsException {
				
		if(reviewService.updateReview(restaurantId,review)) {
			
			return new ResponseEntity<>("Review Updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Review already exist", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/deletereview/{restaurantId}")
	public ResponseEntity<String> deleteReview(@PathVariable("restaurantId") int restaurantId, @RequestBody Review review) throws ReviewAlreadyExistsException, ReviewNotFoundException{
				
		if(reviewService.deleteReview(restaurantId,review)) {
			
			return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(reviewnotfound, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteall/{restaurantId}")
	public ResponseEntity<String> deleteAllReview(@PathVariable("restaurantId") int restaurantId) throws ReviewAlreadyExistsException, ReviewNotFoundException{
				
		if(reviewService.deleteAll(restaurantId)) {
			
			return new ResponseEntity<>("Review Deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(reviewnotfound, HttpStatus.NOT_FOUND);
		}

	}

}
