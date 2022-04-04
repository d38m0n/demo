package com.example.demo.adapter;

import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.OrderEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlOrderRepository extends OrderEntityRepository, JpaRepository<OrderEntity, String> {
}
