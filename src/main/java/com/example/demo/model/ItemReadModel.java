package com.example.demo.model;

import com.example.demo.entity.ItemEntity;

public class ItemReadModel {

    private String brand;
    private String name;
    private String sn;
    private String model;
    private String type;
    private String status;
    private String description;
    private boolean isUsed;


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
