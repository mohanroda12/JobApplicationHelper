package com.jobhelp.jobapplicationhelper.mapper;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JobApplicationMapper implements RowMapper<JobApplication> {
    @Override
    public JobApplication mapRow(ResultSet rs, int rowNum) throws SQLException {

        JobApplication jobApplication = new JobApplication(rs.getLong("application_id"),
                rs.getLong("account_id"),
                rs.getString("company"),
                rs.getString("role"),
                ApplicationStatus.valueOf(rs.getString("status").toUpperCase()),
                rs.getString("location"),
                rs.getDate("date_applied").toLocalDate());

        return jobApplication;
    }
}
