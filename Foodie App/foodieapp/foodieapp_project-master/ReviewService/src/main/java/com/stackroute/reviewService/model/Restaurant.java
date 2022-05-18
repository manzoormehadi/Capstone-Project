package com.stackroute.reviewService.model;

import java.util.List;


@Entity
public class Restaurant {
	
	@Id	
	private int restaurantId;
	private List<Review> review;
	
	public Restaurant() {
		super();
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId +  ", review=" + review
				+ "]";
	}
	
}
