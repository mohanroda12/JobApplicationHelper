package com.jobhelp.jobapplicationhelper.entities;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("job_applications")
public class JobApplicationEntity {

    @Id
    @Column("application_id")
    private Long applicationID;

    @Column("account_id")
    private Long accountID;

    @Column("company")
    private String company;

    @Column("role")
    private String role;

    @Column("status")
    private ApplicationStatus status;

    public JobApplicationEntity() {

    }

    public JobApplicationEntity(Long applicationID, Long accountID, String company, String role, ApplicationStatus status) {
        this.company = company;
        this.applicationID = applicationID;
        this.accountID = accountID;
        this.role = role;
        this.status = status;
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long applicationID) {
        this.applicationID = applicationID;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus applicationStatus) {
        this.status = applicationStatus;
    }

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "applicationID=" + applicationID +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}
