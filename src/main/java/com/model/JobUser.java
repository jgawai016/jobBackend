package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class JobUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String user;
	private String pass;
	 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ad_id")
	private UserAddress address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id")
	private PersonalInfo info;;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_edu_id")
	private Education edu;;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ex_id")
	private Experience exp;;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_sk_id")
	private Skills sk;
	
	public JobUser() {
		super();
	}

	public JobUser(Long id, String user, String pass, UserAddress address, PersonalInfo info, Education edu,
			Experience exp, Skills sk) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.address = address;
		this.info = info;
		this.edu = edu;
		this.exp = exp;
		this.sk = sk;
	}


	public Education getEdu() {
		return edu;
	}

	public void setEdu(Education edu) {
		this.edu = edu;
	}

	public Experience getExp() {
		return exp;
	}

	public void setExp(Experience exp) {
		this.exp = exp;
	}

	public Skills getSk() {
		return sk;
	}

	public void setSk(Skills sk) {
		this.sk = sk;
	}

	public PersonalInfo getInfo() {
		return info;
	}
	
	public void setInfo(PersonalInfo info) {
		this.info = info;
	}
	
	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
