package com.stackroute.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favourite {

	@Id
	@Column(length = 50)
	private String id;

	@Column(length = 50)
	private String name;
	@Column(length = 50)
	private String albumName;
	@Column(length = 50)
	private String artistName;
	@Column(length = 100)
	private String previewURL;
	@Column(length = 50)
	private String loggedInUser;
	@Column(length = 50)
	private String albumId;
	

	
	public Favourite() {
		
	}

	
	

	public String getAlbumId() {
		return albumId;
	}




	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAlbumName() {
		return albumName;
	}


	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}


	public String getArtistName() {
		return artistName;
	}


	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getPreviewURL() {
		return previewURL;
	}


	public void setPreviewURL(String previewURL) {
		this.previewURL = previewURL;
	}


	public String getLoggedInUser() {
		return loggedInUser;
	}


	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	
	

}
