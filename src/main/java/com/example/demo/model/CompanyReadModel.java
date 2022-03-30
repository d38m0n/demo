package com.example.demo.model;

import com.example.demo.entity.CompanyEntity;

public class CompanyReadModel {

    private String name;
    private String status;
    private String description;


    public CompanyReadModel(CompanyEntity source) {
        this.name = source.getName();
        this.status = source.getStatus();
        this.description = source.getDescription();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
