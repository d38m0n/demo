package com.example.demo.repository;


import com.example.demo.entity.CompanyEntity;


import java.util.List;
import java.util.Optional;

public interface CompanyEntityRepository {
    CompanyEntity save(CompanyEntity ce);

    List<CompanyEntity> findAll();

    Optional<CompanyEntity> findById(String id);
}
