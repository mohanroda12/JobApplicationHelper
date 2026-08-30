package com.jobhelp.jobapplicationhelper.config;

import com.jobhelp.jobapplicationhelper.data.JobApplicationDataAccessInterface;
import com.jobhelp.jobapplicationhelper.data.JobApplicationDataServiceForRepository;
import com.jobhelp.jobapplicationhelper.data.UserRepositoryInterface;
import com.jobhelp.jobapplicationhelper.services.UserService;
import com.jobhelp.jobapplicationhelper.services.UserServiceInterface;
import com.jobhelp.jobapplicationhelper.services.JobApplicationService;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name="userService")
    public UserServiceInterface getUserService(UserRepositoryInterface userRepository,
                                               PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, passwordEncoder);
    }

    @Bean(name="jobApplicationService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public JobApplicationServiceInterface getJobApplicationService() {
        return new JobApplicationService();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name="jobApplicationDAO")
    public JobApplicationDataAccessInterface getJobApplicationDataService() {
        return new JobApplicationDataServiceForRepository(dataSource);
//        return new JobApplicationDataService();
    }
}
