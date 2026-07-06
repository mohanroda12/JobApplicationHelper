package com.jobhelp.jobapplicationhelper.models;

public class JobApplication {

    private Long accountID;
    private Long applicationID;
    private String company;
    private String role;
    private ApplicationStatus status;

    public JobApplication(Long applicationID, Long accountID, String company, String role, ApplicationStatus status) {
        this.company = company;
        this.applicationID = applicationID;
        this.accountID = accountID;
        this.role = role;
        this.status = status;
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
