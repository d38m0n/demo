package com.example.demo.adapter;

import com.example.demo.entity.LogbookEntity;
import com.example.demo.repository.LogbookEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlLogbookRepository extends LogbookEntityRepository, JpaRepository<LogbookEntity,String> {
}
