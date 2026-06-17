package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.ArrayList;
import java.util.List;

public class JobApplicationService implements  JobApplicationServiceInterface{

    private List<JobApplication> jobApplications;

    @Override
    public List<JobApplication> getJobApplications() {

        jobApplications.add(new JobApplication("Google", 1L, "Developer", ApplicationStatus.APPLIED));
        jobApplications.add(new JobApplication("Ferrari", 2L, "Engineer", ApplicationStatus.OFFER));
        jobApplications.add(new JobApplication("Gym group", 3L, "Personal trainer", ApplicationStatus.REJECTION));
        jobApplications.add(new JobApplication("Amazon", 4L, "Delivery driver", ApplicationStatus.INTERVIEW));

        return jobApplications;
    }

    @Override
    public void init() {
        System.out.println("Initialization of jobApplication service");
        jobApplications = new ArrayList<>();
    }

    @Override
    public void destroy() {
        System.out.println("Destruction of jobApplication service");
    }
}
