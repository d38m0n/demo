package com.example.demo.adapter;

import com.example.demo.entity.JobsheetEntity;
import com.example.demo.repository.JobsheetEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlJobsheetRepository extends JobsheetEntityRepository, JpaRepository<JobsheetEntity,String> {
}
