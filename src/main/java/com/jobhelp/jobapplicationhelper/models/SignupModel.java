package com.jobhelp.jobapplicationhelper.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignupModel {

    @NotEmpty(message="Please enter an email")
    @Email(message="Please enter a valid email e.g. example@email.com")
    private String email;

    @Size(min=8, max=15, message="Password must be between 8 and 15 characters")
    private String password;

    @Size(min=1, max=15, message="Name must be between 1 and 15 characters")
    private String name;

    public SignupModel() {
    }

    public SignupModel(String password, String email, String username) {
        this.password = password;
        this.email = email;
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SignupModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + name + '\'' +
                '}';
    }
}
