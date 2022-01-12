package com.devsuperior.dsmovie.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_SCORE")
public class Score {
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;
	
	
	public Score() {
		
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}

	public Score(ScorePK id, Double value) {
		super();
		this.id = id;
		this.value = value;
	}



	public ScorePK getId() {
		return id;
	}


	public void setId(ScorePK id) {
		this.id = id;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
