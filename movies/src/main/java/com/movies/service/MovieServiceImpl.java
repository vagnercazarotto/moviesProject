/**
 * 
 */
package com.movies.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.dao.MovieDAO;
import com.movies.entity.Movie;

/**
 * @author a29v
 *
 */
@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieDAO movieDAO;

	@Autowired
	public MovieServiceImpl(MovieDAO theMovieDao) {
		movieDAO = theMovieDao;
	}
	
	@Override
	@Transactional
	public List<Movie> findAll() {
		return movieDAO.findAll();
	}

	@Override
	@Transactional
	public Movie findById(int theId) {
		return movieDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Movie theEmployee) {
		movieDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		movieDAO.deleteById(theId);
	}

}
