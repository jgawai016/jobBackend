package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExperienceRepository;
import com.model.Experience;

@Service
public class ExperienceServiceImpl implements ExperienceService{

	@Autowired
	public ExperienceRepository expRepo;
	
	@Override
	public Experience addExperience(Experience exp) {
		
		return expRepo.save(exp);
	}

	@Override
	public List<Experience> getAllExp() {
		
		return expRepo.findAll();
	}

	@Override
	public Optional<Experience> getExpById(Long id) {
		
		return expRepo.findById(id);
	}

	@Override
	public boolean deleteExp(Long id) {
		
		if(expRepo.existsById(id))
		{
			expRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Experience updateExperience(Long id, Experience exp) {
		if(expRepo.existsById(id)) {
			exp.setId(id);
			return expRepo.save(exp);
		}
		else {
			return exp;
		}
	}

}
