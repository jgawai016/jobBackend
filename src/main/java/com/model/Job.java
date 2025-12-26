package com.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job") 
public class Job {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private LocalDate postedDate;
	
    
    public Job() {
		super();
	}


	public Job(Long id, String title, String description, String location, LocalDate postedDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.postedDate = postedDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public LocalDate getPostedDate() {
		return postedDate;
	}


	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

   
    
}

