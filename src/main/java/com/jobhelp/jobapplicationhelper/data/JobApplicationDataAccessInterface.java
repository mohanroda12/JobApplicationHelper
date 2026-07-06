package com.jobhelp.jobapplicationhelper.data;
import java.util.List;

public interface JobApplicationDataAccessInterface <T>{

    public List<T> getJobApplications();
    public T getByApplicationID(long id);
    public List<T> searchByRole(String searchTerm);

    public long addOne(T newApplication);
    public boolean deleteOne(long id);
    public T updateOne(long idToUpdate, T updatedApplication);

}
