package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Education {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String institute;
	private String dateOfPassing;
	private double percentage;
	
	public Education() {
		super();
	}

	public Education(Long id, String institute, String dateOfPassing, double percentage) {
		super();
		this.id = id;
		this.institute = institute;
		this.dateOfPassing = dateOfPassing;
		this.percentage = percentage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getDateOfPassing() {
		return dateOfPassing;
	}

	public void setDateOfPassing(String dateOfPassing) {
		this.dateOfPassing = dateOfPassing;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
