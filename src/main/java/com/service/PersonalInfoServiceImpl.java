package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PersonalInfoRepository;
import com.model.PersonalInfo;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{

	@Autowired
	public PersonalInfoRepository personalRepo;
	
	@Override
	public PersonalInfo saveInfo(PersonalInfo info) {
		
		return personalRepo.save(info);
	}

	@Override
	public List<PersonalInfo> getAllInfo() {
		
		return personalRepo.findAll();
	}

	@Override
	public Optional<PersonalInfo> getInfoById(Long id) {
		
		return personalRepo.findById(id);
	}

	@Override
	public boolean deleteInfoById(Long id) {
		
		if(personalRepo.existsById(id))
		{
			personalRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public PersonalInfo updateInfo(Long id, PersonalInfo info) {
		
		if(personalRepo.existsById(id)) {
			info.setId(id);
			return personalRepo.save(info);
		}
		else {
			return info;
		}
	}

}
