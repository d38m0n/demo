package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class EvidenceEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String sureName;
    private String pesel;
    private String sex;
    private String street;
    private String city;
    private String country;
    private String nip;
    private String brand;
    private String logoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;


    public EvidenceEntity() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @PrePersist
    void dateCreated() {
        createdOn = LocalDateTime.now();

    }

    @PreUpdate
    void lastUpdate() {
        updatedOn = LocalDateTime.now();
    }

    public void updateFrom(EvidenceEntity source){
        this.name= source.name;
        this.sureName= source.sureName;
        this.pesel= source.pesel;
        this.sex= source.sex;
        this.street= source.street;
        this.city= source.city;
        this.country= source.country;
        this.brand= source.brand;
        this.nip= source.nip;
        this.city= source.city;
        this.logoUrl= source.logoUrl;
    }
}
