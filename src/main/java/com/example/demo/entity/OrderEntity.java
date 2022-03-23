package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private LocalDateTime closedOn;
    private String status;
    private String description;

//    @ManyToMany
//    @JoinTable(name = "orders-items",
//            joinColumns = @JoinColumn(name = "order_id",
//                    referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id",
//                    referencedColumnName = "id"))
//    private Set<ItemEntity> items;



}
