package com.stackroute.reviewService.exception;

@SuppressWarnings("serial")
public class ReviewAlreadyExistsException extends Exception {
	
	public ReviewAlreadyExistsException(String message) {
		super(message);
	}

}

