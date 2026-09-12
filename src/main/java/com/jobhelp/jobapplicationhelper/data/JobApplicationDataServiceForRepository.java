package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.entities.JobApplicationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Class links database table for job applications to a job application model.
 * Maps between JobApplicationEntity (database version) and JobApplication (model)
 * It interacts with data from the database using jobApplicationRepository to complete CREATE, READ, UPDATE and WRITE operations
 */
public class JobApplicationDataServiceForRepository implements JobApplicationDataAccessInterface<JobApplication> {

    @Autowired
    JobApplicationRepositoryInterface jobApplicationRepository;

    private JdbcTemplate jdbcTemplate;
    public ModelMapper modelMapper = new ModelMapper();

    public JobApplicationDataServiceForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<JobApplication> getJobApplications() {
        // get job application entities
        Iterable<JobApplicationEntity> applicationsEntities = jobApplicationRepository.findAll();

        List<JobApplication> applications = new ArrayList<>();

        // Map all entities to job application objects
        for(JobApplicationEntity entity : applicationsEntities) {
            applications.add(modelMapper.map(entity, JobApplication.class));
        }

        return applications;
    }


    @Override
    public JobApplication getByApplicationID(long id) {
        // Get job application entity
        JobApplicationEntity applicationEntity = jobApplicationRepository.findById(id).orElse(null);

        // Map entity to JobApplication object and return
        if(applicationEntity != null) {
            return modelMapper.map(applicationEntity, JobApplication.class);
        }
        return null;
    }

    @Override
    public List<JobApplication> getByAccountID(long accountID) {

        Iterable<JobApplicationEntity> applicationEntity = jobApplicationRepository.findByAccountID(accountID);
        List<JobApplication> applications = new ArrayList<>();

        for(JobApplicationEntity entity : applicationEntity) {
            applications.add(modelMapper.map(entity, JobApplication.class));
        }
        return applications;
    }

    @Override
    public List<JobApplication> searchByRole(String searchTerm, long accountID) {
        Iterable<JobApplicationEntity> entities = jobApplicationRepository.findByRoleContainingIgnoreCaseAndAccountID(searchTerm, accountID);
        List<JobApplication> applications = new ArrayList<>();

        for(JobApplicationEntity entity: entities) {
            applications.add(modelMapper.map(entity, JobApplication.class));
        }

        return applications;
    }

    @Override
    public long addOne(JobApplication newApplication) {

        JobApplicationEntity entity = modelMapper.map(newApplication, JobApplicationEntity.class);

        // So that application doesn't attempt to update
        entity.setApplicationID(null);
        JobApplicationEntity result = jobApplicationRepository.save(entity);

        if(result == null) {
            return 0;
        }
        else {
            return result.getApplicationID();
        }
    }

    @Override
    public boolean deleteOne(long id) {
        jobApplicationRepository.deleteById(id);
        return true;
    }

    @Override
    public JobApplication updateOne(long idToUpdate, JobApplication updatedApplication) {

        // Map and correctly save
        JobApplicationEntity entity = modelMapper.map(updatedApplication, JobApplicationEntity.class);
        JobApplicationEntity result = jobApplicationRepository.save(entity);

        // Return result
        return modelMapper.map(result, JobApplication.class);
    }
}
