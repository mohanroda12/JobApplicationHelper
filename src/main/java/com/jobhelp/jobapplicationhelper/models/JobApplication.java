package com.jobhelp.jobapplicationhelper.models;

public class JobApplication {

    private Long id;
    private String company;
    private String role;
    private ApplicationStatus status;

    public JobApplication(String company, Long id, String role, ApplicationStatus status) {
        this.company = company;
        this.id = id;
        this.role = role;
        this.status = status;
    }

    public JobApplication() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return status;
    }

    public void setStatus(ApplicationStatus applicationStatus) {
        this.status = applicationStatus;
    }

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}
