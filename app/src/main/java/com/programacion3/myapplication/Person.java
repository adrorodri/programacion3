package com.programacion3.myapplication;

import java.io.Serializable;

public class Person implements Serializable {
    private String username;
    private String password;

    Person(String username, String password) {
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
