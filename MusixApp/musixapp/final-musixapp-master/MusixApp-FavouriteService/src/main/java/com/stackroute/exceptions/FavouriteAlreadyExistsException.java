package com.stackroute.exceptions;

@SuppressWarnings("serial")
public class FavouriteAlreadyExistsException extends Exception {
	public FavouriteAlreadyExistsException(String message) {
		super(message);
	}
}
