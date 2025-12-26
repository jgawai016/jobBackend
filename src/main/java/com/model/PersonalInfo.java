package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String fullname;
	private String emailId;
	private Long mobileNo;

	public PersonalInfo() {
		super();
	}

	public PersonalInfo(Long id, String fullname, String emailId, Long mobileNo) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

}
