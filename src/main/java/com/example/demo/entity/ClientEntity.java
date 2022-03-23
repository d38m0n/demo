package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity extends BaseEditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String description1;
    private String description2;
    private boolean isActive;

//    @ManyToMany
//    @JoinTable(name = "clients-items",
//            joinColumns = @JoinColumn(name = "client_id",
//                    referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id",
//                    referencedColumnName = "id"))
//    private Set<ItemEntity> items;

//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "client_id")
//    private Set<OrderEntity> orders;
}
