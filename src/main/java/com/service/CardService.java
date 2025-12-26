package com.service;

import java.util.List;
import java.util.Optional;
import com.model.Card;

public interface CardService {

	public Card saveCard(Card card);
	public List<Card> getAllInfo();
	public Optional<Card> getInfoById(Long id);
	public boolean deleteCardById(Long id);
	public Card updateInfo(Long id,Card card);
}
