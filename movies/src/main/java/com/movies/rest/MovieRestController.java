/**
 * 
 */
package com.movies.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.entity.Movie;
import com.movies.service.MovieService;

/**
 * @author a29v
 *
 */
@RestController
@RequestMapping("/api")
public class MovieRestController {
	
	private MovieService movieService;
	
	@Autowired
	public MovieRestController(MovieService theMovieService) {
		movieService = theMovieService;
	}
	
	// expose "/movies" and return list of movies
	@GetMapping("/movies")
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	// add mapping for GET /movie/{movieId}
	
	@GetMapping("/movies/{movieId}")
	public Movie getMovie(@PathVariable int movieId) {
		
		Movie theMovie = movieService.findById(movieId);
		
		if (theMovie == null) {
			throw new RuntimeException("Movie id not found - " + movieId);
		}
		
		return theMovie;
	}
	
	// add mapping for POST /movie - add new movie
	
	@PostMapping("/movies")
	public Movie addMovie(@RequestBody Movie theMovie) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theMovie.setId(0L);
		
		movieService.save(theMovie);
		
		return theMovie;
	}
	
	// add mapping for PUT /movies - update existing movie
	
	@PutMapping("/movies")
	public Movie updateEmployee(@RequestBody Movie theMovie) {
		
		movieService.save(theMovie);
		
		return theMovie;
	}
	
	// add mapping for DELETE /movies/{movieId} - delete movie
	
	@DeleteMapping("/movies/{movieId}")
	public String deleteEmployee(@PathVariable int movieId) {
		
		Movie tempMovie = movieService.findById(movieId);
		
		// throw exception if null
		
		if (tempMovie == null) {
			throw new RuntimeException("Movie id not found - " + movieId);
		}
		
		movieService.deleteById(movieId);
		
		return "Deleted movie id - " + movieId;
	}
}
