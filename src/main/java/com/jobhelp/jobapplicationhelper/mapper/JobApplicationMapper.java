package com.jobhelp.jobapplicationhelper.mapper;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobApplicationMapper implements RowMapper<JobApplication> {
    @Override
    public JobApplication mapRow(ResultSet rs, int rowNum) throws SQLException {

        JobApplication jobApplication = new JobApplication(rs.getString("COMPANY"),
                rs.getLong("ID"),
                rs.getString("ROLE"),
                ApplicationStatus.valueOf(rs.getString("APPLICATION_STATUS").toUpperCase()));

        return jobApplication;
    }
}
