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
import com.model.PersonalInfo;
import com.service.PersonalInfoService;

@RestController
@RequestMapping("/api/personalinfo")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonalInfoController {

	@Autowired
	public PersonalInfoService personalService;
	
	@PostMapping("/saveInfo")
	public ResponseEntity<PersonalInfo> addProduct(@RequestBody PersonalInfo p)
	{
		PersonalInfo information= personalService.saveInfo(p);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add information successfully!").body(information);
	}
	
	@GetMapping("/getAllInfo")
	public ResponseEntity<List<PersonalInfo>> getAllProduct()
	{
		List<PersonalInfo> infolist = personalService.getAllInfo();
		return ResponseEntity.ok(infolist);
	}
	
	@GetMapping("/infoById/{id}")
	public ResponseEntity<PersonalInfo> getInfoById(@PathVariable Long id)
	{
		Optional<PersonalInfo> product = personalService.getInfoById(id);
		
		if(product.isPresent())
		{
			return ResponseEntity.ok(product.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteInfoById(@PathVariable Long id)
	{
		boolean deleted = personalService.deleteInfoById(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Information Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Information not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PersonalInfo> updatePersonalInfo(@PathVariable Long id,@RequestBody PersonalInfo infor) throws ResourceNotFoundException
	{
		PersonalInfo info = personalService.updateInfo(id, infor);
		return ResponseEntity.ok(info);
	}
	
}
