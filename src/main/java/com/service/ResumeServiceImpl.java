package com.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ResumeRepository;
import com.model.Resume;

@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	public ResumeRepository resRepo;
	
	@Override
	public Resume storeFile(MultipartFile file) {
		String filename = file.getOriginalFilename();
		try {
			Resume res = new Resume();
			res.setFileName(filename);
			res.setData(file.getBytes());
			return resRepo.save(res);
		}
		catch(IOException ex)
		{
			throw new RuntimeException("Could not find file."+filename+" please try again!",ex);
		}
	}

	@Override
	public Optional<Resume> getFile(Long id) {
		
		System.out.println(id+"Inside Service.");
		return resRepo.findById(id);
	}

	@Override
	public List<Resume> getAllFile() {
		
		return resRepo.findAll();
	}

}
