package com.stackroute.exceptions;

@SuppressWarnings("serial")
public class RecommendAlreadyExistsException extends Exception {
	public RecommendAlreadyExistsException(String message) {
		super(message);
	}
}
