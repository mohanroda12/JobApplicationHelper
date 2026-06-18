package com.jobhelp.jobapplicationhelper;

import com.jobhelp.jobapplicationhelper.services.AccountService;
import com.jobhelp.jobapplicationhelper.services.AccountServiceInterface;
import com.jobhelp.jobapplicationhelper.services.JobApplicationService;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SpringConfig {

    @Bean(name="accountService", initMethod = "init", destroyMethod = "destroy")
    public AccountServiceInterface getAccountService() {
        return new AccountService();
    }

    @RequestScope
    @Bean(name="jobApplicationService", initMethod = "init", destroyMethod = "destroy")
    public JobApplicationServiceInterface getJobApplicationService() {
        return new JobApplicationService();
    }
}
