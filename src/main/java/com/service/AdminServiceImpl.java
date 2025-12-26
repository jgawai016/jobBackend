package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	public AdminRepository adminRepo;
	
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		return adminRepo.findAll();
	}

	@Override
	public Optional<Admin> getAdminById(Long id) {
		
		return adminRepo.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		if(adminRepo.existsById(id))
		{
			adminRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Admin updateAdmin(Long id, Admin admin) {
		
		if(adminRepo.existsById(id)) {
			admin.setId(id);
			return adminRepo.save(admin);
		}
		else {
			return admin;
		}
	}

}
