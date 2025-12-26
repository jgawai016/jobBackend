package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Card;

public interface CardRepository extends JpaRepository<Card,Long>{

}
