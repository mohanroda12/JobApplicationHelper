package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.List;

public interface JobApplicationServiceInterface {

    public List<JobApplication> getJobApplications();
    public JobApplication getByID(long id);
    public List<JobApplication> searchByRole(String searchTerm);

    public long addOne(JobApplication newApplication);
    public long deleteOne(long id);
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication);

    public void init();
    public void destroy();

}
