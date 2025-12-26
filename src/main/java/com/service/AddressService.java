package com.service;

import java.util.List;
import java.util.Optional;
import com.model.UserAddress;


public interface AddressService {

	public UserAddress saveAddress(UserAddress address);
	public List<UserAddress> getAllAddress();
	public Optional<UserAddress> getAddressById(Long id);
	public boolean deleteById(Long id);
	public UserAddress updateAddress(Long id,UserAddress address);
	
}
