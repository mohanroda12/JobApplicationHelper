package com.jobhelp.jobapplicationhelper.services;

import com.jobhelp.jobapplicationhelper.data.JobApplicationDataAccessInterface;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

public class JobApplicationService implements JobApplicationServiceInterface{

    @Autowired
    JobApplicationDataAccessInterface<JobApplication> jobApplicationDAO;

    @Override
    public JobApplication getJobApplicationsByApplicationID(long applicationID, long accountID) {
        return jobApplicationDAO.getByApplicationID(applicationID);
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm, long accountID) {
        return jobApplicationDAO.searchByRole(searchTerm, accountID);
    }

    @Override
    public List<JobApplication> getJobApplicationsByAccountID(long accountID) {
        return jobApplicationDAO.getByAccountID(accountID);
    }

    @Override
    public JobApplication addOne(JobApplication newApplication, long currentAccountID) {
        if(newApplication.getAccountID() != currentAccountID) {
            throw new AccessDeniedException("Not authorised to create this application");
        }
        return jobApplicationDAO.addOne(newApplication);
    }

    @Override
    public boolean deleteOne(long idToDelete, long currentAccountID) {
        validateAccountID(idToDelete, currentAccountID);
        return jobApplicationDAO.deleteOne(idToDelete);
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication, long currentAccountID) {
        validateAccountID(idToUpdate, currentAccountID);
        return jobApplicationDAO.updateOne(idToUpdate, updatedApplication);
    }

    /**
     * Checks if an account is authorised to complete an action based on if its account id matches
     * The id that is being used to perform an action
     * @param idToValidate the id used to perform an action with jobApplicationDAO
     * @param userId the users ID when logged in to check against
     */
    private void validateAccountID(long idToValidate, long userId) {
        JobApplication application = jobApplicationDAO.getByApplicationID(idToValidate);

        if(application == null) {
            throw new IllegalArgumentException("No application exists");
        }
        else if(!application.getAccountID().equals(userId)) {
            throw new AccessDeniedException("Not authorised to modify this application");
        }
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
