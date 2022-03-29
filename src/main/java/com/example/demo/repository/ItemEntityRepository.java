package com.example.demo.repository;


import com.example.demo.entity.ItemEntity;

import java.util.List;
import java.util.Optional;

public interface ItemEntityRepository {
    boolean existsBySn(String serialNumber);

    ItemEntity save(ItemEntity itemEntity);

    List<ItemEntity> findAll();

    Optional<ItemEntity> findById(String id);
}
