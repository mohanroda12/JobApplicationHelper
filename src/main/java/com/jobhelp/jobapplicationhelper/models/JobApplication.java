package com.jobhelp.jobapplicationhelper.models;

public class JobApplication {

    private long id;
    private String company;
    private String role;
    private ApplicationStatus applicationStatus;

    public JobApplication(String company, long id, String role, ApplicationStatus applicationStatus) {
        this.company = company;
        this.id = id;
        this.role = role;
        this.applicationStatus = applicationStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return applicationStatus;
    }

    public void setStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", status=" + applicationStatus +
                '}';
    }
}
