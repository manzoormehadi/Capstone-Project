package com.stackroute.reviewService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.reviewService.exception.ReviewAlreadyExistsException;
import com.stackroute.reviewService.exception.ReviewNotFoundException;
import com.stackroute.reviewService.model.Restaurant;
import com.stackroute.reviewService.model.Review;
import com.stackroute.reviewService.repository.ReviewRepository;


	@Service
	public class ReviewServiceImp implements ReviewService
	{
		private ReviewRepository revRepo;
		
		@Autowired
		public ReviewServiceImp(ReviewRepository revRepo) {
			this.revRepo = revRepo;
		}

		@Override
		public boolean saveReview(int restaurantId,Review review) throws ReviewAlreadyExistsException {
			List<Review> reviewList;						
			Optional<Restaurant> resIsPresent = revRepo.findById(restaurantId);
			
			if (!resIsPresent.isPresent()) {
				Restaurant restaurant = new Restaurant();
				reviewList = new ArrayList<>();
				reviewList.add(review);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setReview(reviewList);
				revRepo.save(restaurant);
				return true;

			}
			
			else {
				List<Review> checkReview = resIsPresent.get().getReview();
				
				for(Review newReview:checkReview) {
					if(newReview.getReviewContent().equals(review.getReviewContent())
						&& newReview.getReviewRating()==review.getReviewRating()
						&& newReview.getUserEmail().equals(review.getUserEmail())
							) 
					{
						return false;	
					}
					else 
					{
						if (newReview.getUserEmail().equals(review.getUserEmail()))
					{
						
						return false;						
					}
					}
				}		
						checkReview.add(review);
						Restaurant restaurant = new Restaurant();
						restaurant.setRestaurantId(restaurantId);
						restaurant.setReview(checkReview);
						revRepo.save(restaurant);
						return true;
			}
			
	}
		@Override
		public Restaurant getReviewByRestaurantId(int restaurantId) throws ReviewNotFoundException {
			Optional<Restaurant> reviews = revRepo.findById(restaurantId);
			if (reviews.isPresent()) {
				return revRepo.findById(restaurantId).get();
			} else {
				return null;
			}
		}
		
		public boolean deleteAll(int restaurantId)  {
			Optional<Restaurant> reviews = revRepo.findById(restaurantId);
			if (reviews.isPresent()) {
				revRepo.deleteById(restaurantId);
				return true;
				
			} else {
				return false;
			}
		}
		
		@Override
		public boolean updateReview(int restaurantId,Review review) throws ReviewAlreadyExistsException, ReviewNotFoundException {
				
			Optional<Restaurant> resIsPresent = revRepo.findById(restaurantId);
						
			if (!resIsPresent.isPresent()) {				
				return false;
			}
			
			else {	
				List<Review> checkReview = resIsPresent.get().getReview();
				List<Review> temp = new ArrayList<>();
				boolean flag = false;
				
				for(Review newreview:checkReview) {
					if(newreview.getReviewContent().equals(review.getReviewContent())
						&& newreview.getReviewRating()==review.getReviewRating()
						&& newreview.getUserEmail().equals(review.getUserEmail())
							)
					{		
						return false;				
					}
					else if(newreview.getUserEmail().equals(review.getUserEmail())) {
						temp.add(review);
						flag = true	;
					}
					
					else {
					temp.add(newreview);
					}
					
					}		
						Restaurant restaurant = new Restaurant();
						restaurant.setRestaurantId(restaurantId);
						restaurant.setReview(temp);
						revRepo.save(restaurant);
						return flag;
		}			
			
		}
		
		@Override
		public boolean deleteReview(int restaurantId,Review review) throws ReviewNotFoundException {
			Optional<Restaurant> resIsPresent = revRepo.findById(restaurantId);
			List<Review> newReviewList = new ArrayList<>();
			if (!resIsPresent.isPresent()) {				
				return false;
			}
			
			List<Review> checkReview = resIsPresent.get().getReview();
			if(checkReview.size()==1){
				revRepo.deleteById(restaurantId);
				return true;				
			}
			else {				
				boolean flag = false;
				for(Review newreview:checkReview) {
					if(newreview.getReviewContent().equals(review.getReviewContent())
						&& newreview.getReviewRating()==review.getReviewRating()
						&& newreview.getUserEmail().equals(review.getUserEmail())
							)
					{						
						flag = true;				
					}
					else {
						newReviewList.add(newreview);
					}
				}
						Restaurant restaurant = new Restaurant();
						restaurant.setRestaurantId(restaurantId);
						restaurant.setReview(newReviewList);
						revRepo.save(restaurant);
						return flag;
		}
	}

}
