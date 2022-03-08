package com.example.demo.model;

public class UserUpdateModel {
    private String id;
    private String company_id;
    private String login;
    private String psw;
    private String newPsw;
    private String email;
    private boolean isActive;

    public UserUpdateModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNewPsw() {
        return newPsw;
    }

    public void setNewPsw(String newPsw) {
        this.newPsw = newPsw;
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
}
