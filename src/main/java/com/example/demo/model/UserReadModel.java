package com.example.demo.model;

import com.example.demo.entity.UserEntity;

public class UserReadModel {
    private String login;
    private String email;
    private boolean isActive;
    private String evidence_id;


    public UserReadModel() {
    }

    public UserReadModel(UserEntity source) {
        this.email = source.getEmail();
        this.isActive = source.isActive();
        this.login = source.getLogin();
        this.evidence_id = source.getEvidence_id().getId();
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

    public String getEvidence_id() {
        return evidence_id;
    }

    public void setEvidence_id(String evidence_id) {
        this.evidence_id = evidence_id;
    }
}
