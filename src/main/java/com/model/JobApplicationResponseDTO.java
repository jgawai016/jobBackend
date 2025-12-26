package com.model;

import java.time.LocalDate;

public class JobApplicationResponseDTO {
    private Long id;
    private String applicantName;
    private String applicantEmail;
    private LocalDate applicationDate;
    private String resumeDownloadUrl;
    private String resumeFileName;
    
    
	public JobApplicationResponseDTO() {
		super();
	}


	public JobApplicationResponseDTO(Long id, String applicantName, String applicantEmail, LocalDate applicationDate,
			String resumeDownloadUrl, String resumeFileName) {
		super();
		this.id = id;
		this.applicantName = applicantName;
		this.applicantEmail = applicantEmail;
		this.applicationDate = applicationDate;
		this.resumeDownloadUrl = resumeDownloadUrl;
		this.resumeFileName = resumeFileName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getApplicantName() {
		return applicantName;
	}


	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}


	public String getApplicantEmail() {
		return applicantEmail;
	}


	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}


	public LocalDate getApplicationDate() {
		return applicationDate;
	}


	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}


	public String getResumeDownloadUrl() {
		return resumeDownloadUrl;
	}


	public void setResumeDownloadUrl(String resumeDownloadUrl) {
		this.resumeDownloadUrl = resumeDownloadUrl;
	}


	public String getResumeFileName() {
		return resumeFileName;
	}


	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}

	
    
    
    
}
