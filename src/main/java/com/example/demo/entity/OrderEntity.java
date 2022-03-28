package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Set<ItemEntity> items;


}
