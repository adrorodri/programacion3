package com.programacion3.myapplication;

import java.io.Serializable;

/**
 * Created by adro_ on 4/9/2018.
 */

public class Person implements Serializable {
    public String username;
    public String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
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
}
