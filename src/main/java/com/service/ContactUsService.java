package com.service;

import java.util.List;
import java.util.Optional;

import com.model.ContactUs;

public interface ContactUsService {

	public ContactUs addQuestion(ContactUs con);
	public List<ContactUs> getAllQuestion();
	public Optional<ContactUs> getQueById(Long id);
	public boolean deleteQuestion(Long id);
	public ContactUs update (Long id,ContactUs con);
	
}
