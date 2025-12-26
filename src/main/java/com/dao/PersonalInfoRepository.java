package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo,Long>{

}
