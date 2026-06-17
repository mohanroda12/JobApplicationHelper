package com.jobhelp.jobapplicationhelper.models;

public enum ApplicationStatus {
    APPLIED,
    INTERVIEW,
    OFFER,
    REJECTION;

    @Override
    public String toString() {
        String lower = name().toLowerCase();
        // Make first character uppercase
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
