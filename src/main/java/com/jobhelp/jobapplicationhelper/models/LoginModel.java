package com.jobhelp.jobapplicationhelper.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotEmpty(message="Please enter an email")
    @Email(message="Please enter a valid email e.g. example@email.com")
    private String email;

    @Size(min=8, max=15, message="Password must be between 8 and 15 characters")
    private String password;

    public LoginModel() {
    }

    public LoginModel(String password, String email) {
        this.password = password;
        this.email = email;
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

    @Override
    public String toString() {
        return "LoginModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
