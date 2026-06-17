package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/applications")
public class JobApplicationController {

    @Autowired
    JobApplicationServiceInterface jobApplication;

    @GetMapping("")
    public String showAllApplications(Model model) {

        List<JobApplication> applications = jobApplication.getJobApplications();
        model.addAttribute("applications", applications);

        return "applications";
    }

}
