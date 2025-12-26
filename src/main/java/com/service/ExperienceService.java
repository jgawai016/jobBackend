package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Experience;

public interface ExperienceService {

	public Experience addExperience(Experience exp);
	public List<Experience> getAllExp();
	public Optional<Experience> getExpById(Long id);
	public boolean deleteExp(Long id);
	public Experience updateExperience(Long id,Experience exp);
}
