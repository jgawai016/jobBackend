package com.controller;

import com.model.JobApplication;
import com.service.ApplicationService;
import com.model.JobApplicationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    public ApplicationService applicationService;

    @PostMapping(value = "/apply", consumes = "multipart/form-data")
    public ResponseEntity<JobApplication> applyForJob(
            @RequestParam("jobId") Long jobId,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("resume") MultipartFile resume
    ) {
        JobApplication application = applicationService.applyForJob(jobId, name, email, resume);
        return ResponseEntity.ok(application);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<JobApplicationResponseDTO>> getApplicationsForJob(@PathVariable Long jobId) {
        List<JobApplication> applications = applicationService.getApplicationsForJob(jobId);

        List<JobApplicationResponseDTO> response = applications.stream().map(app -> {
            JobApplicationResponseDTO dto = new JobApplicationResponseDTO();
            dto.setId(app.getId());
            dto.setApplicantName(app.getApplicantName());
            dto.setApplicantEmail(app.getApplicantEmail());
            dto.setApplicationDate(app.getApplicationDate());
            dto.setResumeDownloadUrl("/api/applications/" + app.getId() + "/resume");
            dto.setResumeFileName(app.getResumeFileName());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/resume")
    public ResponseEntity<ByteArrayResource> downloadResume(@PathVariable Long id) {
        JobApplication application = applicationService.getApplicationById(id);
        byte[] data = application.getResumeData();
        String fileName = application.getResumeFileName();

        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(data.length)
                .body(resource);
    }

}
