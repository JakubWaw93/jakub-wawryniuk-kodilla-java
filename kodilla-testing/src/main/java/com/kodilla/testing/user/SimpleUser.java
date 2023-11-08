package com.kodilla.testing.user;

public class SimpleUser {

    private String userName;
    private String realName;

    public SimpleUser(String userName) {
        this.userName = userName;
    }

    public SimpleUser(String username, String realName) {
        this.userName = username;
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }
}
