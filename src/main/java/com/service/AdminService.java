package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Admin;

public interface AdminService {

	public Admin saveAdmin(Admin admin);
	public List<Admin> getAllAdmin();
	public Optional<Admin> getAdminById(Long id);
	public boolean deleteById(Long id);
	public Admin updateAdmin(Long id,Admin admin);
}
