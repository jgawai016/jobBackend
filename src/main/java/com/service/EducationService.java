package com.service;

import java.util.List;
import java.util.Optional;
import com.model.Education;

public interface EducationService {

	public Education saveEducation(Education edu);
	public List<Education> getAllEducation();
	public Optional<Education> getEducationById(Long id);
	public boolean deleteEducationById(Long id);
	public Education updateEducation(Long id,Education edu);
}
