package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Favourite {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int favId;
	@Id
	@Column(length = 50)
	private int restaurantId;
	@Column(length = 50)
	private String restaurantName;
	@Column(length = 50)
	private String loggedInUser;
	/*@Column(length = 50)
	private String email;*/
	@Column
	private String address;
	
	public Favourite(int favId, int restaurantId, String restaurantName, String loggedInUser, String address)
	{
		super();
		this.favId = favId;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.loggedInUser = loggedInUser;
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Favourite()
	{
		
	}
	

	public int getFavId() {
		return favId;
	}

	public void setFavId(int favId) {
		this.favId = favId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

}
