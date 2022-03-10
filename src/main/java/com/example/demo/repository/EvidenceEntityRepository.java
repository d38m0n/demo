package com.example.demo.repository;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EvidenceEntityRepository {
    boolean existsById(String id);

    boolean existsByNip(String nip);

    boolean existsByPesel(String pesel);

    List<EvidenceEntity> findAll();

    Optional<EvidenceEntity> findById(String id);

    Page<EvidenceEntity> findAll(Pageable p);

    EvidenceEntity save(EvidenceEntity ue);

    void deleteById(String id);

    Optional<EvidenceEntity> findByPesel(String id);
}
