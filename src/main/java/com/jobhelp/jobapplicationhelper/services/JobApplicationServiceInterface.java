package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.List;

public interface JobApplicationServiceInterface {

    public List<JobApplication> getJobApplications();
    public void init();
    public void destroy();

}
