package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.model.Resume;

public interface ResumeService {

	public Optional<Resume> getFile(Long id);
	public List<Resume> getAllFile();
	public Resume storeFile(MultipartFile file);
}
