package com.example.demo.model;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.UserEntity;

public class UserWriteModel {

    private String login;
    private String psw;
    private String email;
    private EvidenceEntity evidence_id;

    public UserWriteModel() {
    }

    public UserEntity getUserEntity() {
        return new UserEntity(psw, login, email);
    }

    public UserEntity getUserEntity(EvidenceEntity evidenceEntity) {
        return new UserEntity(psw, login, email, evidenceEntity);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EvidenceUpdateModel getEvidenceModel() {
        return new EvidenceUpdateModel(this.evidence_id);

    }

    public EvidenceEntity getEvidence_id() {
        return evidence_id;
    }

    public void setEvidence_id(EvidenceEntity evidence_id) {
        this.evidence_id = evidence_id;
    }
}
