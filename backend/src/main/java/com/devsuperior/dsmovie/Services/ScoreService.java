package com.devsuperior.dsmovie.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.DTO.MovieDto;
import com.devsuperior.dsmovie.DTO.ScoreDTO;
import com.devsuperior.dsmovie.Entities.Movie;
import com.devsuperior.dsmovie.Entities.Score;
import com.devsuperior.dsmovie.Entities.User;
import com.devsuperior.dsmovie.Repositories.MovieRepository;
import com.devsuperior.dsmovie.Repositories.ScoreRepository;
import com.devsuperior.dsmovie.Repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDto saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			
			sum += s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDto(movie);
	}
	
	

}
