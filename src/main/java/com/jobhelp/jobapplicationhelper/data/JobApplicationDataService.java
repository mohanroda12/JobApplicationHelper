package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.models.JobApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobApplicationDataService implements JobApplicationDataAccessInterface<JobApplication>{

    // mysql connection details from application.properties
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<JobApplication> getJobApplications() {
        return jdbcTemplate.query("SELECT * FROM JOB_APPLICATIONS", new JobApplicationMapper());
    }

    @Override
    public JobApplication getByID(long id) {
        List<JobApplication> results = jdbcTemplate.query("SELECT * FROM JOB_APPLICATIONS WHERE ID = ?", new JobApplicationMapper(), id);
        if(!results.isEmpty()) {
            return results.getFirst();
        }
        else {
            return null;
        }
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm) {
        return jdbcTemplate.query("SELECT * FROM JOB_APPLICATIONS WHERE ROLE LIKE ?", new JobApplicationMapper(), "%" + searchTerm.toLowerCase() + "%");
    }

    @Override
    // Returns ID number of element inserted
    public long addOne(JobApplication newApplication) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("JOB_APPLICATIONS").usingGeneratedKeyColumns("ID");

        // Hash map
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("COMPANY", newApplication.getCompany());
        parameters.put("ROLE", newApplication.getRole());
        parameters.put("APPLICATION_STATUS", newApplication.getStatus().name());

        Number result = simpleJdbcInsert.executeAndReturnKey(parameters);

        return result.longValue();
    }

    @Override
    public boolean deleteOne(long id) {
        int result = jdbcTemplate.update("DELETE FROM JOB_APPLICATIONS WHERE ID = ?", id);
        if(result > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {

        int result = jdbcTemplate.update("UPDATE JOB_APPLICATIONS SET COMPANY = ?, ROLE = ?, APPLICATION_STATUS = ? WHERE ID = ?",
                updatedApplication.getCompany(),
                updatedApplication.getRole(),
                updatedApplication.getStatus().name(),
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
