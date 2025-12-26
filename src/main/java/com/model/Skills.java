package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skills {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String skillset;
	
	public Skills() {
		super();
	}

	public Skills(Long id, String skillset) {
		super();
		this.id = id;
		this.skillset = skillset;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
}
