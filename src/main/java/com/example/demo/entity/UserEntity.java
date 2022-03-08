package com.example.demo.entity;

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
    @OneToMany()
    @JoinColumn(name = "logbook_id")
    private Set<LogbookEntity> logbook;


    public UserEntity() {
    }

    public UserEntity(String psw, String login, String email) {
        this.login = login;
        this.psw = psw;
        this.email = email;
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

    public void updateFrom(final UserEntity source) {
        this.email = source.email;
        this.psw = source.psw;
        this.isActive = source.isActive;
        this.login = source.login;
        this.logbook = source.logbook;
        this.company_id = source.company_id;

    }
}
