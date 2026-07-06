package com.jobhelp.jobapplicationhelper.data.prototypes;

import com.jobhelp.jobapplicationhelper.data.JobApplicationDataAccessInterface;
import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.ArrayList;
import java.util.List;

public class JobApplicationFakeDAO implements JobApplicationDataAccessInterface<JobApplication> {

    private List<JobApplication> jobApplications = new ArrayList<>();

    public JobApplicationFakeDAO() {
        jobApplications.add(new JobApplication(1L, 1L, "Google", "Developer", ApplicationStatus.APPLIED));
        jobApplications.add(new JobApplication(2L, 2L, "Ferrari", "Engineer", ApplicationStatus.OFFER));
        jobApplications.add(new JobApplication(3L, 3L, "Gym group", "Personal trainer", ApplicationStatus.REJECTION));
        jobApplications.add(new JobApplication(4L, 4L, "Amazon", "Delivery driver", ApplicationStatus.INTERVIEW));
    }

    @Override
    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    @Override
    public JobApplication getByApplicationID(long id) {

        for(JobApplication application : jobApplications) {
            if(application.getApplicationID() == id) {
                return application;
            }
        }
        // No application by id found
        return null;
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm) {

        List<JobApplication> foundTerms = new ArrayList<>();

        for(JobApplication application : jobApplications) {
            if(application.getRole().toLowerCase().contains(searchTerm.toLowerCase())) {
                foundTerms.add(application);
            }
        }
        return foundTerms;
    }

    @Override
    public long addOne(JobApplication newApplication) {
        boolean success = jobApplications.add(newApplication);

        if(success) {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean deleteOne(long id) {

        for(int i = 0; i < jobApplications.size(); i++) {
            if(jobApplications.get(i).getApplicationID() == id) {
                jobApplications.remove(i);
                return true;
            }
        }
        // No application by id found
        return false;
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {

        for(int i = 0; i < jobApplications.size(); i++) {
            if(jobApplications.get(i).getApplicationID() == idToUpdate) {
                jobApplications.set(i, updatedApplication);
                return jobApplications.get(i);
            }
        }
        // No application by id found
        return null;
    }
}
