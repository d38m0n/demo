package com.example.demo.adapter;

import com.example.demo.entity.ItemEntity;
import com.example.demo.repository.ItemEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlItemRepository extends ItemEntityRepository, JpaRepository<ItemEntity,String> {
}
