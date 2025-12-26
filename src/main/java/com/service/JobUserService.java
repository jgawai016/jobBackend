package com.service;

import java.util.List;
import java.util.Optional;
import com.model.JobUser;

public interface JobUserService {

	public JobUser savejob(JobUser jobuser);
	public List<JobUser> getAllJob();
	public Optional<JobUser> getJobById(Long id);
	public boolean deleteJobById(Long id);
	public JobUser updateJob(Long id,JobUser job);
}
