package com.jobhelp.jobapplicationhelper.entities;

import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

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

    @Column("location")
    private String location;

    @Column("date_created")
    private LocalDate dateApplied;

    public JobApplicationEntity() {

    }

    public JobApplicationEntity(Long applicationID,
                                Long accountID,
                                String company,
                                String role,
                                ApplicationStatus status,
                                String location,
                                LocalDate dateApplied) {
        this.company = company;
        this.applicationID = applicationID;
        this.accountID = accountID;
        this.role = role;
        this.status = status;
        this.location = location;
        this.dateApplied = dateApplied;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
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
