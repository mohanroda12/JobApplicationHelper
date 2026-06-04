package com.jobhelp.jobapplicationhelper.models;

public class Account {

    // attributes
    private int id;
    private String name;
    private String email;

    public Account(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
