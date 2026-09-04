package com.automation.qa.model;

/**
 * Representa el cuerpo (payload) enviado al crear/actualizar un usuario
 * en la API de reqres.in (POST/PUT /api/users).
 */
public class User {

    private String name;
    private String job;

    public User() {
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
