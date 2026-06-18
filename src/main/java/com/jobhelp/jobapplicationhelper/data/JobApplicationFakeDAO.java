package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobApplicationFakeDAO implements JobApplicationDataAccessInterface {

    private List<JobApplication> jobApplications = new ArrayList<>();

    public JobApplicationFakeDAO() {
        jobApplications.add(new JobApplication("Google", 1L, "Developer", ApplicationStatus.APPLIED));
        jobApplications.add(new JobApplication("Ferrari", 2L, "Engineer", ApplicationStatus.OFFER));
        jobApplications.add(new JobApplication("Gym group", 3L, "Personal trainer", ApplicationStatus.REJECTION));
        jobApplications.add(new JobApplication("Amazon", 4L, "Delivery driver", ApplicationStatus.INTERVIEW));
    }

    @Override
    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    @Override
    public JobApplication getByID(long id) {

        for(JobApplication application : jobApplications) {
            if(application.getId() == id) {
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
            if(jobApplications.get(i).getId() == id) {
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
            if(jobApplications.get(i).getId() == idToUpdate) {
                jobApplications.set(i, updatedApplication);
                return jobApplications.get(i);
            }
        }
        // No application by id found
        return null;
    }
}
