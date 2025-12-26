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

import com.model.UserAddress;
import com.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	public AddressService addrService;
	
	@PostMapping("/saveaddress")
	public ResponseEntity<UserAddress> addAddress(UserAddress address)
	{
		UserAddress ad = addrService.saveAddress(address);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add Address successfully!").body(ad);
	}
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<List<UserAddress>> getAllAddress()
	{
		List<UserAddress> addr = addrService.getAllAddress();
		return ResponseEntity.ok(addr);
	}
	
	@GetMapping("/getuserById/{id}")
	public ResponseEntity<UserAddress> getUserById(@PathVariable Long id)
	{
		Optional<UserAddress> addr = addrService.getAddressById(id);
		
		if(addr.isPresent())
		{
			return ResponseEntity.ok(addr.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/updateAddress")
	public ResponseEntity<UserAddress> updateAddress(@PathVariable Long id,@RequestBody UserAddress address)
	{
		UserAddress addr = addrService.updateAddress(id, address);
		return ResponseEntity.ok(addr);
	}
	
	@DeleteMapping("/deleteAddress")
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		boolean deleted = addrService.deleteById(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Address deleted Successfully!");
		}
		else {
			return ResponseEntity.status(404).body("Address Not deleted!!!");
		}
	}
}
