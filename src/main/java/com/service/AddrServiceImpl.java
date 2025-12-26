package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AddressRepository;
import com.model.UserAddress;

@Service
public class AddrServiceImpl implements AddressService{

	@Autowired
	public AddressRepository addrRepo;

	@Override
	public UserAddress saveAddress(UserAddress address) {
		
		return addrRepo.save(address);
	}

	@Override
	public List<UserAddress> getAllAddress() {
		List <UserAddress> addr = addrRepo.findAll();
		return addr;
	}

	@Override
	public Optional<UserAddress> getAddressById(Long id) {
		Optional<UserAddress> addr = addrRepo.findById(id);
		return addr;
	}

	@Override
	public boolean deleteById(Long id) {
		if(addrRepo.existsById(id))
		{
			addrRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public UserAddress updateAddress(Long id, UserAddress address) {
		if(addrRepo.existsById(id))
		{
			address.setAdd_id(id);
			return addrRepo.save(address);
		}
		return address;
	}
	
	
}
