package com.example.demo.entity;

import com.example.demo.model.UserUpdateModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String login;
    private String psw;
    private String email;
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<LogbookEntity> logbook;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<OrderEntity> orders;

    public UserEntity() {
    }

    public String getId() {
        return id;
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

    public UserEntity addAuthorizationDate(LogbookEntity logbookEntity) {
        this.logbook.add(logbookEntity);
        return this;
    }

    public UserEntity updateFrom(final UserUpdateModel source) {

        this.email = source.getEmail();
        this.login = source.getLogin();
        this.isActive = source.isActive();
        return this;

    }
}
