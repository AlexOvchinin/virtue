package com.fm.virtue.api;

public class UserResource {
    private final String username;
    private final String password;

    public UserResource(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
