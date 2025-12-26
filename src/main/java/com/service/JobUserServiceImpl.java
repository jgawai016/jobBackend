package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.JobUserRepository;
import com.model.JobUser;

@Service
public class JobUserServiceImpl implements JobUserService{

	@Autowired
	public JobUserRepository jobRepo;
	
	@Override
	public JobUser savejob(JobUser jobuser) {
		
		return jobRepo.save(jobuser);
	}

	@Override
	public List<JobUser> getAllJob() {
		
		return jobRepo.findAll();
	}

	@Override
	public Optional<JobUser> getJobById(Long id) {
		
		return jobRepo.findById(id);
	}

	@Override
	public boolean deleteJobById(Long id) {
		if(jobRepo.existsById(id))
		{
			jobRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public JobUser updateJob(Long id, JobUser job) {
		
		if(jobRepo.existsById(id)) {
			job.setId(id);
			return jobRepo.save(job);
		}
		else {
			return job;
		}
	}

}
