package com.devsuperior.dsmovie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
