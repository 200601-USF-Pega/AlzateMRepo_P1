package com.revature.onlinestoreapp.models;

//Add validation for when user is inputting this certain variable when creating object
public class User {
    private String userID;
    private String email;
    private String password;
    private String userType;
    private boolean isAdmin;

    public User() {
    }

    public User(String userID, String email, String password, String userType, boolean isAdmin) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.isAdmin = isAdmin;
    }

    //Constructor used when a new user is creating a customer account
    public User(String email, String password, String userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User " +
                "userID='" + userID + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
