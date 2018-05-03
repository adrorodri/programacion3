package com.programacion3.myapplication.Model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Person implements Serializable {

    @Expose
    private String username;

    @Expose
    private String password;

    @Expose
    private String nombre;

    @Expose
    private String apellido;

    @Expose
    private int codigoUpb;

    Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Person(String nombre, String apellido, int codigoUpb) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUpb = codigoUpb;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigoUpb() {
        return codigoUpb;
    }

    public void setCodigoUpb(int codigoUpb) {
        this.codigoUpb = codigoUpb;
    }
}
