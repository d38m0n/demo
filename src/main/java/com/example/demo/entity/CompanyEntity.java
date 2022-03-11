package com.example.demo.entity;


import com.example.demo.model.CompanyUpdateModel;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEditEntity {

    private String name;
    private String status;
    private String description;

    public CompanyEntity() {
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

    public void setStatus(String description_1) {
        this.status = description_1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description_2) {
        this.description = description_2;
    }

    public CompanyEntity updateFrom(final CompanyUpdateModel store) {
        this.description = store.getDescription();
        this.name = store.getName();
        this.status = store.getStatus();
        return this;
    }

}
