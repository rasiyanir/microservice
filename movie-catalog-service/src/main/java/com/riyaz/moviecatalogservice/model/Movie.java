package com.riyaz.moviecatalogservice.model;

public class Movie {

	private String movieID;
	private String moviename;
	
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieID, String moviename) {
		super();
		this.movieID = movieID;
		this.moviename = moviename;
	}
	
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	
}
