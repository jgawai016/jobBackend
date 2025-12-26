package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}

