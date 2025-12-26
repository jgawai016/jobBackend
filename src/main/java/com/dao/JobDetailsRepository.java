package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.JobDetails;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {
    
}

