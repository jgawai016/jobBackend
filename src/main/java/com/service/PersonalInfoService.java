package com.service;

import java.util.List;
import java.util.Optional;

import com.model.PersonalInfo;

public interface PersonalInfoService {

	public PersonalInfo saveInfo(PersonalInfo info);
	public List<PersonalInfo> getAllInfo();
	public Optional<PersonalInfo> getInfoById(Long id);
	public boolean deleteInfoById(Long id);
	public PersonalInfo updateInfo(Long id,PersonalInfo info);
}
