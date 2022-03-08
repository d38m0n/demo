package com.example.demo.repository;


import com.example.demo.entity.CompanyEntity;
import com.example.demo.entity.UserEntity;

public interface CompanyEntityRepository {
    CompanyEntity save(CompanyEntity ce);
}
