package com.jobhelp.jobapplicationhelper.data;

import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.models.JobApplicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobApplicationRepositoryInterface extends CrudRepository<JobApplicationEntity, Long> {
    List<JobApplicationEntity> findByRoleContainingIgnoreCase(String searchTerm);
}
