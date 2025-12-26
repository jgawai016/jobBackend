package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class JobDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;

    @Column(length = 5000)
    private String description;

    private String category;

    private String jobType;

    private String salary;

    private String experience;

    @Column(name = "skills_required")
    private String skillsRequired;

    private String location;

	public JobDetails() {
		super();
	}

	public JobDetails(Long id, String position, String description, String category, String jobType, String salary,
			String experience, String skillsRequired, String location) {
		super();
		this.id = id;
		this.position = position;
		this.description = description;
		this.category = category;
		this.jobType = jobType;
		this.salary = salary;
		this.experience = experience;
		this.skillsRequired = skillsRequired;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    
}
