package com.programacion3.myapplication;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Person implements Serializable {

    @Expose
    private String username;

    @Expose
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
