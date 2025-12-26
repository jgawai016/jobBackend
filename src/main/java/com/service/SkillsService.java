package com.service;

import java.util.List;
import java.util.Optional;
import com.model.Skills;

public interface SkillsService {

	public Skills saveSkills(Skills s);
	public List<Skills> getAllSkills();
	public Optional<Skills> getSkillsById(Long id);
	public boolean deleteSkills(Long id);
	public Skills updateSkills(Long id,Skills sk);
}
