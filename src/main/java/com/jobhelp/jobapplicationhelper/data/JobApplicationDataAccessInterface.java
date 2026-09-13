package com.jobhelp.jobapplicationhelper.data;
import com.jobhelp.jobapplicationhelper.models.JobApplication;

import java.util.List;

public interface JobApplicationDataAccessInterface <T>{

    public List<T> getJobApplications();
    public T getByApplicationID(long id);
    public List<T> getByAccountID(long accountID);
    public List<T> searchByRole(String searchTerm, long accountID);

    public JobApplication addOne(T newApplication);
    public boolean deleteOne(long id);
    public T updateOne(long idToUpdate, T updatedApplication);

}
