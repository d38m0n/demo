package com.example.demo.model;

import com.example.demo.entity.UserEntity;

import java.time.LocalDateTime;

public class UserReadModel {
    private String company_id;
    private String login;
    private String email;
    private boolean isActive;
    private LocalDateTime logger;

    public UserReadModel() {

    }

    public UserReadModel (UserEntity source) {
        this.company_id = source.getCompany_id();
        this.email = source.getEmail();
        this.isActive = source.isActive();
        this.login = source.getLogin();
        this.logger = source.getLogger();
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getLogger() {
        return logger;
    }

    public void setLogger(LocalDateTime logger) {
        this.logger = logger;
    }
}
