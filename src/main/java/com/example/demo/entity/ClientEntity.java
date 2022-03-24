package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class ClientEntity extends BaseEditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String description1;
    private String description2;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Set<ItemEntity> items;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Set<OrderEntity> orders;
}
