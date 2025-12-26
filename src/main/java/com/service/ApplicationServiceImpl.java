package com.service;

import com.dao.ApplicationRepository;
import com.dao.JobRepository;
import com.model.Job;
import com.model.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    
    @Override
    public JobApplication applyForJob(Long jobId, String name, String email, MultipartFile resumeFile) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));

        try {
            JobApplication application = new JobApplication();
            application.setJob(job);
            application.setApplicantName(name);
            application.setApplicantEmail(email);
            application.setResumeData(resumeFile.getBytes());
            application.setResumeFileName(resumeFile.getOriginalFilename()); // Save actual file name
            application.setApplicationDate(LocalDate.now());

            return applicationRepository.save(application);
        } catch (IOException e) {
            throw new RuntimeException("Error reading resume file", e);
        }
    }

    @Override
    public List<JobApplication> getApplicationsForJob(Long jobId) {
        return applicationRepository.findByJob_Id(jobId);
    }

    @Override
    public JobApplication getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with ID: " + id));
    }

    @Override
    public byte[] getResume(Long applicationId) {
        JobApplication application = getApplicationById(applicationId);
        return application.getResumeData();
    }
    
    
}
