package com.devsuperior.dsmovie.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.DTO.MovieDto;
import com.devsuperior.dsmovie.DTO.ScoreDTO;
import com.devsuperior.dsmovie.Services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDto findById(@RequestBody ScoreDTO dto){
		MovieDto movieDto = service.saveScore(dto);
		return movieDto;
	}

}
