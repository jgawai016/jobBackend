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
import com.model.ContactUs;
import com.service.ContactUsService;

@RestController
@RequestMapping("/api/contactus")
@CrossOrigin("http://localhost:3000")
public class ContactUsController {
	
	@Autowired
	public ContactUsService conService;
	
	@PostMapping("/savequestion")
	public ResponseEntity<ContactUs> addQuestion(@RequestBody ContactUs con)
	{
		ContactUs que = conService.addQuestion(con);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add your question successfully!").body(que);
	}

	@GetMapping("/getAllQuestion")
	public ResponseEntity<List<ContactUs>> getAllQuestion()
	{
		List<ContactUs> queList = conService.getAllQuestion();
		return ResponseEntity.ok(queList);
	}
	
	@GetMapping("/getQuestionById/{id}")
	public ResponseEntity<ContactUs> getQueById(@PathVariable Long id)
	{
		Optional<ContactUs> queById = conService.getQueById(id);
		
		if(queById.isPresent())
		{
			return ResponseEntity.ok(queById.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable Long id)
	{
		boolean deleted = conService.deleteQuestion(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Question Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Question not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ContactUs> updateProduct(@PathVariable Long id,@RequestBody ContactUs con)
	{
		ContactUs que = conService.update(id, con);
		return ResponseEntity.ok(que);
	}
	
}
