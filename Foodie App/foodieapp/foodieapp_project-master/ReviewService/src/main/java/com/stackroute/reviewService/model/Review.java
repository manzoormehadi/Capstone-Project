package com.stackroute.reviewService.model;

public class Review {

	private int reviewRating;
	private String reviewContent;
	private String userEmail;

	public Review() {
		super();
	}
	
	
	public Review(int reviewRating, String reviewContent, String userEmail) {
		super();
		this.reviewRating = reviewRating;
		this.reviewContent = reviewContent;
		this.userEmail = userEmail;
	}


	public int getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "Review [reviewRating=" + reviewRating + ", reviewContent=" + reviewContent + ", userEmail=" + userEmail
				+ "]";
	}
			
}
