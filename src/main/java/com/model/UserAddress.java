package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long add_id;
	private String city;
	private String state;
	private double pincode;
	
	public UserAddress() {
		super();
	}

	public UserAddress(Long add_id, String city, String state, double pincode) {
		super();
		this.add_id = add_id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Long getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getPincode() {
		return pincode;
	}

	public void setPincode(double pincode) {
		this.pincode = pincode;
	}
}
