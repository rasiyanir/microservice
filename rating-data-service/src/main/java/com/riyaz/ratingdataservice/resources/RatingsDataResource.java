package com.riyaz.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyaz.ratingdataservice.models.Rating;
import com.riyaz.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("ratingsdata")
public class RatingsDataResource {

	@RequestMapping("{movieID}")
	public Rating getRating(@PathVariable String movieID) {
		return new Rating(movieID, 4);
	}
	
	@RequestMapping("users/{userID}")
	public UserRating getMovieRating(@PathVariable String userID) {
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), 
											 new Rating("5678", 3));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
