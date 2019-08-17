package com.riyaz.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyaz.movieinfoservice.models.Movie;

@RestController
@RequestMapping("movies")
public class MovieResource {

	@RequestMapping("{MovieID}")
	public Movie getMovie(@PathVariable String MovieID) {
		return new Movie(MovieID, "Test Movie");
	}
}
