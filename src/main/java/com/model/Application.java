package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String pos;
	
	public Application() {
		super();
	}

	public Application(Long id, String pos) {
		super();
		this.id = id;
		this.pos = pos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}
}
