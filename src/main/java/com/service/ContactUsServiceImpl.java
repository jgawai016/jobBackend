package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ContactUsRepository;
import com.model.ContactUs;

@Service
public class ContactUsServiceImpl implements ContactUsService{

	@Autowired
	public ContactUsRepository conRepo;
	
	@Override
	public ContactUs addQuestion(ContactUs con) {
		return conRepo.save(con);
	}

	@Override
	public List<ContactUs> getAllQuestion() {
	
		return conRepo.findAll();
	}

	@Override
	public Optional<ContactUs> getQueById(Long id) {
		
		return conRepo.findById(id);
	}

	@Override
	public boolean deleteQuestion(Long id) {
		
		if(conRepo.existsById(id))
		{
			conRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public ContactUs update(Long id, ContactUs con) {
		
		if(conRepo.existsById(id)) {
			con.setId(id);
			return conRepo.save(con);
		}
		else {
			return con;
		}
	}

}
