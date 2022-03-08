package com.example.demo.adapter;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.repository.CompanyEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlCompanyRepository extends CompanyEntityRepository, JpaRepository<CompanyEntity,String> {
}
