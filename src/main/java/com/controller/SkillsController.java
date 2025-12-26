package com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Skills;
import com.service.SkillsService;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin("http://localhost:3000")
public class SkillsController {

	@Autowired
	public SkillsService sService;
	
	@PostMapping("/addskills")
	public ResponseEntity<Skills> addExperience(@RequestBody Skills s)
	{
		Skills sk = sService.saveSkills(s);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add Skills successfully!").body(sk);
	}
	
	@GetMapping("/getAllSkills")
	public ResponseEntity<List<Skills>> getAllSkills()
	{
		return ResponseEntity.ok(sService.getAllSkills());
	}
	
	@GetMapping("/getSkillsById")
	public ResponseEntity<Optional<Skills>> getSkillsById(@PathVariable Long id)
	{
		Optional<Skills> sk= sService.getSkillsById(id);
		return ResponseEntity.ok(sk);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSkills(@PathVariable Long id)
	{
		boolean deleted = sService.deleteSkills(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Skills Detail Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Skill detail not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Skills> updateExperience(@PathVariable Long id,@RequestBody Skills s)
	{
		Skills sk = sService.updateSkills(id, s);
		return ResponseEntity.ok(sk);
	}
}
