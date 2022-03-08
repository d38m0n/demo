package com.example.demo.model;

import com.example.demo.entity.UserEntity;

public class UserWriteModel {

    private String login;
    private String psw;
    private String email;

    public UserWriteModel() {
    }

    public UserEntity getUserEntity(){
        return new UserEntity(psw,login,email);
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
}
