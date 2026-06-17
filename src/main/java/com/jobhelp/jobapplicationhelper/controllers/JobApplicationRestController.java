package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
public class JobApplicationRestController {

    @Autowired
    JobApplicationServiceInterface jobApplication;

    @GetMapping("")
    public List<JobApplication> showAllApplications() {
        return jobApplication.getJobApplications();
    }

    @GetMapping("/searchByRole/{searchTerm}")
    public List<JobApplication> searchApplicationByRole(@PathVariable String searchTerm) {
        return jobApplication.searchByRole(searchTerm);
    }

    @PostMapping("/")
    public long addOneApplication(@RequestBody JobApplication newApplication) {
        return jobApplication.addOne(newApplication);
    }

}
