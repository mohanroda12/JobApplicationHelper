package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.List;

public interface JobApplicationServiceInterface {

    public JobApplication getJobApplicationsByApplicationID(long applicationID);
    public List<JobApplication> searchByRole(String searchTerm, long accountID);
    public List<JobApplication> getJobApplicationsByAccountID(long accountID);


    public long addOne(JobApplication newApplication, long currentAccountID);
    public boolean deleteOne(long idToDelete, long currentAccountID);
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication, long currentAccountID);

    public void init();
    public void destroy();

}
