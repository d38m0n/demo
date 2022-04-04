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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDateTime getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(LocalDateTime closedOn) {
        this.closedOn = closedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }

    public OrderEntity addItem(ItemEntity itemEntity) {
        this.items.add(itemEntity);
        return this;
    }

    public OrderEntity deleteItem(ItemEntity itemEntity) {
        this.items.remove(itemEntity);
        return this;
    }
}
