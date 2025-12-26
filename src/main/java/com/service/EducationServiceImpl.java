package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EducationRepository;
import com.model.Education;

@Service
public class EducationServiceImpl implements EducationService{

	@Autowired
	public EducationRepository eduRepo;
	
	@Override
	public Education saveEducation(Education edu) {
		
		return eduRepo.save(edu);
	}

	@Override
	public List<Education> getAllEducation() {
		
		return eduRepo.findAll();
	}

	@Override
	public Optional<Education> getEducationById(Long id) {
		
		return eduRepo.findById(id);
	}

	@Override
	public boolean deleteEducationById(Long id) {
		if(eduRepo.existsById(id))
		{
			eduRepo.deleteById(id);
			return true;
		}
		
		return false;
	}

	@Override
	public Education updateEducation(Long id, Education edu) {
		
		if(eduRepo.existsById(id)) {
			edu.setId(id);
			return eduRepo.save(edu);
		}
		else {
			return edu;
		}
	}

}
