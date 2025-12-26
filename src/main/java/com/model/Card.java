package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String cname;
	private String position;
	private String discription;
	private String category;
	private String jobtype;
	private double salary;
	private double experience;
	private String address;
	private String pdate;
	private String edetail;
	private String rskill;
	
	public Card() {
		super();
	}

	public Card(Long id, String cname, String position, String discription, String category, String jobtype,
			double salary, double experience, String address, String pdate, String edetail, String rskill) {
		super();
		this.id = id;
		this.cname = cname;
		this.position = position;
		this.discription = discription;
		this.category = category;
		this.jobtype = jobtype;
		this.salary = salary;
		this.experience = experience;
		this.address = address;
		this.pdate = pdate;
		this.edetail = edetail;
		this.rskill = rskill;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getEdetail() {
		return edetail;
	}

	public void setEdetail(String edetail) {
		this.edetail = edetail;
	}

	public String getRskill() {
		return rskill;
	}

	public void setRskill(String rskill) {
		this.rskill = rskill;
	}
	
}
