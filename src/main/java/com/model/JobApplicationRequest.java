package com.model;

public class JobApplicationRequest {
    private Long jobId;
    private JobApplication jobApplication;
	public JobApplicationRequest() {
		super();
	}
	public JobApplicationRequest(Long jobId, JobApplication jobApplication) {
		super();
		this.jobId = jobId;
		this.jobApplication = jobApplication;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public JobApplication getJobApplication() {
		return jobApplication;
	}
	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}

    
}

