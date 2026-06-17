package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.List;

public class JobApplicationFakeDAO implements JobApplicationDataAccessInterface {
    @Override
    public List<JobApplication> getJobApplications() {
        return List.of();
    }

    @Override
    public JobApplication getByID(long id) {
        return null;
    }

    @Override
    public List<JobApplication> searchJobApplications(String searchTerm) {
        return List.of();
    }

    @Override
    public long addOne(JobApplication newApplication) {
        return 0;
    }

    @Override
    public long deleteOne(long id) {
        return 0;
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {
        return null;
    }
}
