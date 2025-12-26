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
import com.model.Education;
import com.service.EducationService;

@RestController
@RequestMapping("/api/education")
@CrossOrigin("http://localhost:3000")
public class EducationController {

	@Autowired
	public EducationService eduService;
	
	@PostMapping("/saveeducation")
	public ResponseEntity<Education> saveEducation(@RequestBody Education edu)
	{
		Education education = eduService.saveEducation(edu);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add highest details successfully!").body(education);
	}
	
	@GetMapping("/getAllEducation")
	public ResponseEntity<List<Education>> getAllEducation()
	{
		List<Education> eduList = eduService.getAllEducation();
		return ResponseEntity.ok(eduList);
		
	}
	
	@GetMapping("/getEduById")
	public ResponseEntity<Education> getEduById(@PathVariable Long id)
	{
		Optional<Education> eduById = eduService.getEducationById(id);
		
		if(eduById.isPresent())
		{
			return ResponseEntity.ok(eduById.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEducationById(@PathVariable Long id)
	{
		boolean deleted = eduService.deleteEducationById(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Education Detail Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Education detail not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Education> updateEducation(@PathVariable Long id,@RequestBody Education edu)
	{
		Education updateEducation = eduService.updateEducation(id, edu);
		return ResponseEntity.ok(updateEducation);
	}
	
}
