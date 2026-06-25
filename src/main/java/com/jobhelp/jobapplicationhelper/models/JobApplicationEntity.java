package com.jobhelp.jobapplicationhelper.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("JOB_APPLICATIONS")
public class JobApplicationEntity {

    @Id
    @Column("ID")
    private Long id;

    @Column("COMPANY")
    private String company;

    @Column("ROLE")
    private String role;

    @Column("APPLICATION_STATUS")
    private ApplicationStatus applicationStatus;

    public JobApplicationEntity() {

    }

    public JobApplicationEntity(String company, Long id, String role, ApplicationStatus applicationStatus) {
        this.company = company;
        this.id = id;
        this.role = role;
        this.applicationStatus = applicationStatus;
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
