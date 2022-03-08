package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEditEntity {

    private String brand;
    private String name;
    private String status;
    private String description;

    public CompanyEntity() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public void updateFrom(final CompanyEntity store) {
        this.brand = store.brand;
        this.description = store.description;
        this.name = store.name;
        this.status = store.status;
    }
}
