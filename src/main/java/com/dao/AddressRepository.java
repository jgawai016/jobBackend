package com.dao;

import com.model.UserAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<UserAddress,Long>{

}
