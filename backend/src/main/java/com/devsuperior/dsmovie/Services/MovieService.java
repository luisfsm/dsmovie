package com.devsuperior.dsmovie.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.DTO.MovieDto;
import com.devsuperior.dsmovie.Entities.Movie;
import com.devsuperior.dsmovie.Repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDto> findAllMovies(Pageable pageable) {
	    Page<Movie> result = repository.findAll(pageable);
	    Page<MovieDto> page = result.map(x -> new MovieDto(x));
	    return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDto findById(Long id) {
	    Movie result = repository.findById(id).get();
	    MovieDto dto = new MovieDto(result);
	    return dto;
	}

}
