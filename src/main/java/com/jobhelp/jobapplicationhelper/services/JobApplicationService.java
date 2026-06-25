package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.data.JobApplicationDataAccessInterface;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobApplicationService implements  JobApplicationServiceInterface{

    @Autowired
    JobApplicationDataAccessInterface<JobApplication> jobApplicationDAO;

    @Override
    public List<JobApplication> getJobApplications() {
        return jobApplicationDAO.getJobApplications();
    }

    @Override
    public JobApplication getByID(long id) {
        return jobApplicationDAO.getByID(id);
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm) {
        return jobApplicationDAO.searchByRole(searchTerm);
    }

    @Override
    public long addOne(JobApplication newApplication) {
        return jobApplicationDAO.addOne(newApplication);
    }

    @Override
    public boolean deleteOne(long id) {
        return jobApplicationDAO.deleteOne(id);
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {
        return jobApplicationDAO.updateOne(idToUpdate, updatedApplication);
    }

    @Override
    public void init() {
        System.out.println("Initialization of jobApplication service");
    }

    @Override
    public void destroy() {
        System.out.println("Destruction of jobApplication service");
    }
}
