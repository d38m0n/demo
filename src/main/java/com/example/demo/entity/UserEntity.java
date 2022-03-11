package com.example.demo.entity;

import com.example.demo.model.UserUpdateModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEditEntity {

    private String company_id;
    private String login;
    private String psw;
    private String email;
    private boolean isActive;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "logbook_id")
    private Set<LogbookEntity> logbook;


    public UserEntity() {
    }

    public UserEntity(String psw, String login, String email) {
        this.login = login;
        this.psw = psw;
        this.email = email;
    }

    public UserEntity(String psw, String login, String email, EvidenceEntity source) {
        this.login = login;
        this.psw = psw;
        this.email = email;
        this.setEvidence_id(source);
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<LogbookEntity> getLogbook() {
        return logbook;
    }

    public void setLogbook(Set<LogbookEntity> logger) {
        this.logbook = logger;
    }


    public UserEntity updateFrom(final UserUpdateModel source) {
        this.company_id = source.getCompany_id();
        this.email = source.getEmail();
        this.login = source.getLogin();
        this.isActive = source.isActive();
        return this;

    }
}
