package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.List;

public interface JobApplicationDataAccessInterface {

    public List<JobApplication> getJobApplications();
    public JobApplication getByID(long id);
    public List<JobApplication> searchJobApplications(String searchTerm);

    public long addOne(JobApplication newApplication);
    public long deleteOne(long id);
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication);

}
