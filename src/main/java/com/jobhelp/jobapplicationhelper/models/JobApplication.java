package com.jobhelp.jobapplicationhelper.models;

import java.time.LocalDate;

public class JobApplication {

    private Long accountID;
    private Long applicationID;
    private String company;
    private String role;
    private ApplicationStatus status;
    private String location;
    private LocalDate dateApplied;

    public JobApplication(Long applicationID,
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

    public JobApplication() {

    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long id) {
        this.applicationID = id;
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
