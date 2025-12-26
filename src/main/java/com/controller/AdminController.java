package com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Admin;
import com.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;
	
	@PostMapping("/saveadmin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin)
	{
		Admin ad = adminService.saveAdmin(admin);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add Admin detail successfully!").body(ad);
	}
	
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmin()
	{
		List<Admin> adm = adminService.getAllAdmin();
		return ResponseEntity.ok(adm);
	}
	
	@GetMapping("/getuserById/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id)
	{
		Optional<Admin> adm = adminService.getAdminById(id);
		
		if(adm.isPresent())
		{
			return ResponseEntity.ok(adm.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,@RequestBody Admin admin)
	{
		Admin adm = adminService.updateAdmin(id, admin);
		return ResponseEntity.ok(adm);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		boolean deleted = adminService.deleteById(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Admin Detail deleted Successfully!");
		}
		else {
			return ResponseEntity.status(404).body("Admin Not deleted!!!");
		}
	}
	
}
