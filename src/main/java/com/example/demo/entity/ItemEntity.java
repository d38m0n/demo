package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String brand;
    private String name;
    private String sn;
    private String model;
    private String type;
    private String status;
    private String description;
    private boolean isUsed;

}
