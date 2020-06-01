package com.example.connectfour;

public class User {

    private String pushId;
    String username;
    String password;
    String emailId;

    public User()
    {

    }

    public User(String name,String password,String emailId) {
        this.username = name;
        this.password=password;
        this.emailId=emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
