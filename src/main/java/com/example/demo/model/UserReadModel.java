package com.example.demo.model;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.UserEntity;

public class UserReadModel {
    private String login;
    private String email;
    private boolean isActive;
    private EvidenceEntity evidence_id;


    public UserReadModel() {
    }

    public UserReadModel(UserEntity source) {
        this.email = source.getEmail();
        this.isActive = source.isActive();
        this.login = source.getLogin();
        this.evidence_id = source.getEvidence_id();

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

    public EvidenceEntity getEvidence_id() {
        return evidence_id;
    }
    public String cratedON() {
        return evidence_id.getCreatedOn() ;
    }

    public void setEvidence_id(EvidenceEntity evidence_id) {
        this.evidence_id = evidence_id;
    }
}
