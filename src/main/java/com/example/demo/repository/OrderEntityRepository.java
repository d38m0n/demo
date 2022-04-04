package com.example.demo.repository;


import com.example.demo.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderEntityRepository {
    boolean existsById(String id);

    void deleteById(String id);

    OrderEntity save(OrderEntity jobsheet);

    List<OrderEntity> findAll();

    Optional<OrderEntity> findById(String id);
}
