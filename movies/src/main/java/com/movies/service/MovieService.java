/**
 * 
 */
package com.movies.service;

import java.util.List;

import com.movies.entity.Movie;

/**
 * @author a29v
 *
 */
public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findById(int theId);
	
	public void save(Movie theEmployee);
	
	public void deleteById(int theId);

}
