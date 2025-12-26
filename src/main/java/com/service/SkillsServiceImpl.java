package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SkillsRepository;
import com.model.Skills;

@Service
public class SkillsServiceImpl implements SkillsService{

	@Autowired
	public SkillsRepository sRepo;
	
	@Override
	public Skills saveSkills(Skills s) {
		
		return sRepo.save(s);
	}

	@Override
	public List<Skills> getAllSkills() {
		
		return sRepo.findAll();
	}

	@Override
	public Optional<Skills> getSkillsById(Long id) {
		
		return sRepo.findById(id);
	}

	@Override
	public boolean deleteSkills(Long id) {
		
		if(sRepo.existsById(id))
		{
			sRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Skills updateSkills(Long id, Skills s) {
		
		if(sRepo.existsById(id)) {
			s.setId(id);
			return sRepo.save(s);
		}
		else {
			return s;
		}
	}

}
