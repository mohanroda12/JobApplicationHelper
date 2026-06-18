package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.models.JobApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JobApplicationDataService implements JobApplicationDataAccessInterface{

    // mysql connection details from application.properties
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<JobApplication> getJobApplications() {
        List<JobApplication> results = jdbcTemplate.query("SELECT * FROM JOB_APPLICATIONS", new JobApplicationMapper());
        return results;
    }

    @Override
    public JobApplication getByID(long id) {
        return null;
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm) {
        return List.of();
    }

    @Override
    public long addOne(JobApplication newApplication) {
        return 0;
    }

    @Override
    public boolean deleteOne(long id) {
        return false;
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {
        return null;
    }
}
