package com.example.demo.entity;

import com.example.demo.model.EvidenceUpdateModel;

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

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private  UserEntity user;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private CompanyEntity company;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @PrePersist
    void dateCreated() {
        createdOn = LocalDateTime.now();

    }

    @PreUpdate
    void lastUpdate() {
        updatedOn = LocalDateTime.now();
    }

    public EvidenceEntity updateFrom(EvidenceUpdateModel source){
        this.name= source.getName();
        this.sureName= source.getSureName();
        this.pesel= source.getPesel();
        this.sex= source.getSex();
        this.street= source.getStreet();
        this.city= source.getCity();
        this.country= source.getCountry();
        this.brand= source.getBrand();
        this.nip= source.getNip();
        this.city= source.getCity();
        this.logoUrl= source.getLogoUrl();
        return this;
    }
}
