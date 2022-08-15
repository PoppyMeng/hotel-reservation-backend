package com.example.demo;

public class ShallowUserResponse {
    private User user;
    public ShallowUserResponse(User user){
        this.user=user;

    }
    public Long getId() {
        return user.getId();
    }


    public String getEmail() {
        return user.getEmail();
    }

    public String getUserName() {
        return user.getUserName();
    }
}
