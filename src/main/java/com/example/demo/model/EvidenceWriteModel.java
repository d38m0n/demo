package com.example.demo.model;

import com.example.demo.entity.EvidenceEntity;

public class EvidenceWriteModel {
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

    public EvidenceWriteModel() {
    }

    public EvidenceWriteModel(EvidenceEntity source) {
        this.name = source.getName();
        this.sureName = source.getSureName();
        this.pesel = source.getPesel();
        this.sex = source.getSex();
        this.street = source.getStreet();
        this.city = source.getCity();
        this.country = source.getCountry();
        this.nip = source.getNip();
        this.brand = source.getBrand();
        this.logoUrl = getLogoUrl();
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

    public EvidenceEntity getEntityEvidence() {

        return new EvidenceEntity().updateFrom(this);
    }
}
