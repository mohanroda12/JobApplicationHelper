package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.models.SearchModel;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("searchModel", new SearchModel());

        return "applications";
    }

    @GetMapping("/addNew")
    public String addNewApplicationForm(Model model) {

        model.addAttribute("application", new JobApplication());
        model.addAttribute("statuses", ApplicationStatus.values());

        return "addNewApplication";
    }

    @PostMapping("/saveNew")
    public String addNewApplication(@Valid JobApplication newApplication, BindingResult bindingResult, Model model) {
        newApplication.setId(null);
        jobApplication.addOne(newApplication);
        return "redirect:/applications";
    }

    @PostMapping("/search/role")
    public String searchByRole(@Valid SearchModel searchModel, BindingResult bindingResult, Model model) {

        String searchTerm = searchModel.getSearchTerm();

        //Filter by search term
        List<JobApplication> applications = jobApplication.searchByRole(searchTerm);
        model.addAttribute("applications", applications);

        return "applications";
    }
}


