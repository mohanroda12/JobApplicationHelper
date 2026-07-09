package com.jobhelp.jobapplicationhelper.models;

public enum ApplicationStatus {
    APPLIED("Applied"),
    INTERVIEW("Interview"),
    OFFER("Offer"),
    REJECTION("Rejection");

    private final String displayName;

    ApplicationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


//    @Override
//    public String toString() {
//        String lower = name().toLowerCase();
//        // Make first character uppercase
//        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
//    }
}
