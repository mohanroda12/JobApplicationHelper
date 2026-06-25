package com.jobhelp.jobapplicationhelper;

import com.jobhelp.jobapplicationhelper.data.JobApplicationDataAccessInterface;
import com.jobhelp.jobapplicationhelper.data.JobApplicationDataService;
import com.jobhelp.jobapplicationhelper.data.JobApplicationDataServiceForRepository;
import com.jobhelp.jobapplicationhelper.data.JobApplicationFakeDAO;
import com.jobhelp.jobapplicationhelper.services.AccountService;
import com.jobhelp.jobapplicationhelper.services.AccountServiceInterface;
import com.jobhelp.jobapplicationhelper.services.JobApplicationService;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name="accountService", initMethod = "init", destroyMethod = "destroy")
    public AccountServiceInterface getAccountService() {
        return new AccountService();
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
