package com.example.demo.repository;


import com.example.demo.entity.JobsheetEntity;

import java.util.List;
import java.util.Optional;

public interface JobsheetEntityRepository {
    boolean existsById(String id);
    void deleteById(String id);

    JobsheetEntity save(JobsheetEntity jobsheet);

    List<JobsheetEntity> findAll();

    Optional<JobsheetEntity> findById(String id);
}
