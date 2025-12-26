package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CardRepository;
import com.model.Card;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	public CardRepository cardRepo;
	
	@Override
	public Card saveCard(Card card) {
		
		return cardRepo.save(card);
	}

	@Override
	public List<Card> getAllInfo() {
		
		return cardRepo.findAll();
	}

	@Override
	public Optional<Card> getInfoById(Long id) {
		
		return cardRepo.findById(id);
	}

	@Override
	public boolean deleteCardById(Long id) {
		if(cardRepo.existsById(id))
		{
			cardRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Card updateInfo(Long id, Card card) {
		
		if(cardRepo.existsById(id)) {
			card.setId(id);
			return cardRepo.save(card);
		}
		else {
			return card;
		}
	}

}
