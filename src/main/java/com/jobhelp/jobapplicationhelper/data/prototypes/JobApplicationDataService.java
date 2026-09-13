package com.jobhelp.jobapplicationhelper.data.prototypes;

import com.jobhelp.jobapplicationhelper.data.JobApplicationDataAccessInterface;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.mapper.JobApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobApplicationDataService implements JobApplicationDataAccessInterface<JobApplication> {

    // mysql connection details from application.properties
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<JobApplication> getJobApplications() {
        return jdbcTemplate.query("SELECT * FROM job_applications", new JobApplicationMapper());
    }

    @Override
    public JobApplication getByApplicationID(long id) {
        List<JobApplication> results = jdbcTemplate.query("SELECT * FROM job_applications WHERE application_id = ?", new JobApplicationMapper(), id);
        if(!results.isEmpty()) {
            return results.getFirst();
        }
        else {
            return null;
        }
    }

    @Override
    public List<JobApplication> getByAccountID(long accountID) {
        return jdbcTemplate.query("SELECT * FROM job_applications WHERE account_id=? ORDER BY date_applied ASC",
                new JobApplicationMapper(),
                accountID);
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm, long accountID) {
        return jdbcTemplate.query("SELECT * FROM job_applications WHERE role LIKE ? AND account_id=?", new JobApplicationMapper(),
                "%" + searchTerm.toLowerCase() + "%",
                accountID);
    }

    @Override
    // Returns ID number of element inserted
    public JobApplication addOne(JobApplication newApplication) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("job_applications").usingGeneratedKeyColumns("application_id");

        // Hash map
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("company", newApplication.getCompany());
        parameters.put("role", newApplication.getRole());
        parameters.put("status", newApplication.getStatus().name());
        parameters.put("location", newApplication.getLocation());
        parameters.put("date_applied", newApplication.getDateApplied());
        parameters.put("account_id", newApplication.getAccountID());

        Number generatedID = simpleJdbcInsert.executeAndReturnKey(parameters);
        newApplication.setApplicationID(generatedID.longValue());

        return newApplication;
    }

    @Override
    public boolean deleteOne(long id) {
        int result = jdbcTemplate.update("DELETE FROM job_applications WHERE application_id = ?", id);
        return result > 0;
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {

        int result = jdbcTemplate.update("UPDATE job_applications SET COMPANY = ?, ROLE = ?, STATUS = ?, LOCATION = ?, DATE_APPLIED = ? WHERE application_id = ?",
                updatedApplication.getCompany(),
                updatedApplication.getRole(),
                updatedApplication.getStatus().name(),
                updatedApplication.getLocation(),
                updatedApplication.getDateApplied(),
                idToUpdate);

        // If it is correctly updated
        if(result > 0) {
            return updatedApplication;
        }
        else {
            return null;
        }
    }
}
