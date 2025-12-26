package com.service;

import com.model.JobApplication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ApplicationService {

    JobApplication applyForJob(Long jobId, String name, String email, MultipartFile resumeFile);

    List<JobApplication> getApplicationsForJob(Long jobId);

    JobApplication getApplicationById(Long id);

    byte[] getResume(Long applicationId); // Retrieve resume bytes for download/view
}
