package com.fm.virtue.api;

public class UserResponse {
    private final long id;

    public UserResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
