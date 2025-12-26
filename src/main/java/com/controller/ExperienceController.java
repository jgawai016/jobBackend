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
import com.model.Experience;
import com.service.ExperienceService;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin("http://localhost:3000")
public class ExperienceController {

	@Autowired
	public ExperienceService expService;
	
	@PostMapping("/addexperience")
	public ResponseEntity<Experience> addExperience(@RequestBody Experience exp)
	{
		Experience ex = expService.addExperience(exp);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add Experience successfully!").body(ex);
	}
	
	@GetMapping("/getAllExperience")
	public ResponseEntity<List<Experience>> getAllExp()
	{
		return ResponseEntity.ok(expService.getAllExp());
	}
	
	@GetMapping("/getExpById")
	public ResponseEntity<Optional<Experience>> getExpById(@PathVariable Long id)
	{
		Optional<Experience> ex= expService.getExpById(id);
		return ResponseEntity.ok(ex);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteExp(@PathVariable Long id)
	{
		boolean deleted = expService.deleteExp(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Experience Detail Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Experience detail not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Experience> updateExperience(@PathVariable Long id,@RequestBody Experience exp)
	{
		Experience ex = expService.updateExperience(id, exp);
		return ResponseEntity.ok(ex);
	}
}
