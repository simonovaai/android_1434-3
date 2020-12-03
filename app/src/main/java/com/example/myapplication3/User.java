package com.example.myapplication3;

import java.util.UUID;

public class User {
    private String userName;
    private String userLastName;
    private UUID uuid;

    public User() {
        this.uuid = UUID.randomUUID(); // случайный номер id пользователя
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UUID getUuid() {
        return uuid;
    }
}
