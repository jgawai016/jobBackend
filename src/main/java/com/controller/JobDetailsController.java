package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dao.JobDetailsRepository;
import com.model.JobDetails;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobDetailsController {

    @Autowired
    private JobDetailsRepository jobDetailsRepository;

    @GetMapping
    public String listJobs(Model model) {
        List<JobDetails> jobs = jobDetailsRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "job-list";
    }

    @GetMapping("/{id}")
    public String getJobDetails(@PathVariable Long id, Model model) {
        JobDetails job = jobDetailsRepository.findById(id).orElse(null);
        model.addAttribute("job", job);
        return "job-details";
    }

    @GetMapping("/new")
    public String showCreateJobForm(Model model) {
        model.addAttribute("job", new JobDetails());
        return "create-job";
    }

    @PostMapping
    public String createJob(@ModelAttribute JobDetails job) {
        jobDetailsRepository.save(job);
        return "redirect:/jobs";
    }
}
