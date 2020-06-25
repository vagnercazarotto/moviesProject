/**
 * 
 */
package com.movies.dao;

import java.util.List;

import com.movies.entity.Movie;

/**
 * @author a29v
 *
 */
public interface MovieDAO {

	public List<Movie> findAll();
	
	public Movie findById(int theId);
	
	public void save(Movie theMovie);
	
	public void deleteById(int theId);
}
