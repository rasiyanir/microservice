package com.riyaz.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.riyaz.moviecatalogservice.model.CatalogItem;
import com.riyaz.moviecatalogservice.model.Movie;
import com.riyaz.moviecatalogservice.model.Rating;
import com.riyaz.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("catalog")
public class movieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("{userID}")
	public List<CatalogItem> getCatalog(@PathVariable String userID){
		
		//get all rated movie Ids
		/*
		 * List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new
		 * Rating("5678", 3));
		 */
		
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userID, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> 
		{
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieID(), Movie.class);
			
			return new CatalogItem(movie.getMoviename(), "abcd", rating.getRating());
			})
			.collect(Collectors.toList());
		
		/*
		 * List<CatalogItem> catList;
		 * 
		 * catList = Arrays.asList(new CatalogItem("a", "abcd", 4), new CatalogItem("b",
		 * "abcd", 3), new CatalogItem("c", "abcd", 5));
		 * 
		 * return catList;
		 */
	}
	
}


/*
 * Movie movie = webClientBuilder.build() 
 * .get()
 * .uri("http://localhost:8082/movies/" + rating.getMovieID()) 
 * .retrieve()
 * .bodyToMono(Movie.class) 
 * .block();
 */
