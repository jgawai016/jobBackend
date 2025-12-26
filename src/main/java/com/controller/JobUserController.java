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
import com.model.JobUser;
import com.service.JobUserService;

@RestController
@RequestMapping("/jobuser")
@CrossOrigin(origins="http://localhost:3000")
public class JobUserController {

	@Autowired
	public JobUserService jobService;
	
	@PostMapping("/saveuser")
	public ResponseEntity<JobUser> addUser(@RequestBody JobUser username)
	{
		JobUser us = jobService.savejob(username);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add User successfully!").body(us);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<JobUser>> getAllJob()
	{
		List<JobUser> juList = jobService.getAllJob();
		return ResponseEntity.ok(juList);
		
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<JobUser> getEduById(@PathVariable Long id)
	{
		Optional<JobUser> jobById = jobService.getJobById(id);
		
		if(jobById.isPresent())
		{
			return ResponseEntity.ok(jobById.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id)
	{
		boolean deleted = jobService.deleteJobById(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Job Detail Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Job detail not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<JobUser> updateJob(@PathVariable Long id, @RequestBody JobUser job)
	{
		JobUser updateJob = jobService.updateJob(id, job);
		return ResponseEntity.ok(updateJob);
	}
	
}
