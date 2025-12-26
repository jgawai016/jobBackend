package com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Card;
import com.service.CardService;

@RestController
@RequestMapping("/card")
@CrossOrigin(origins="http://localhost:3000")
public class CardController {

	@Autowired
	public CardService cardService;
	
	@PostMapping("/savecard")
	public ResponseEntity<Card> addUser(@RequestBody Card card)
	{
		Card cd = cardService.saveCard(card);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "add User successfully!").body(cd);
	}
	
	@GetMapping("/getAllCard")
	public ResponseEntity<List<Card>> getAllEducation()
	{
		List<Card> cardList = cardService.getAllInfo();
		return ResponseEntity.ok(cardList);
		
	}
	
	@GetMapping("/getCardById/{id}")
	public ResponseEntity<Card> getEduById(@PathVariable Long id)
	{
		Optional<Card> cardById = cardService.getInfoById(id);
		
		if(cardById.isPresent())
		{
			return ResponseEntity.ok(cardById.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEducationById(@PathVariable Long id)
	{
		boolean deleted = cardService.deleteCardById(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Card Detail Deleted Successfully!!");
		}
		else {
			return ResponseEntity.status(404).body("Card detail not found");
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Card> updateInfo(@PathVariable Long id, @RequestBody Card card)
	{
		Card updateCard = cardService.updateInfo(id, card);
		return ResponseEntity.ok(updateCard);
	}
	
}
