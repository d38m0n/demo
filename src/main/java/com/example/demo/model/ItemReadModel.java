package com.example.demo.model;

public class ItemReadModel {

    private String id;
    private String brand;
    private String name;
    private String sn;
    private String model;
    private String type;
    private String status;
    private String description;
    private boolean isUsed;

    public ItemReadModel() {
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getSn() {
        return sn;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUsed() {
        return isUsed;
    }
}
