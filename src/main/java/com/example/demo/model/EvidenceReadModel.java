package com.example.demo.model;

import com.example.demo.entity.EvidenceEntity;

public class EvidenceReadModel {
    private String name;
    private String sureName;
    private String pesel;
    private String country;
    private String nip;
    private String brand;

    public EvidenceReadModel() {

    }

    public EvidenceReadModel(EvidenceEntity source) {
        this.name = source.getName();
        this.sureName = source.getSureName();
        this.pesel = source.getPesel();
        this.country = source.getCountry();
        this.nip = source.getNip();
        this.brand = source.getBrand();

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
}
