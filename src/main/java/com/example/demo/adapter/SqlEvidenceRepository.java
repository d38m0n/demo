package com.example.demo.adapter;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.EvidenceEntityRepository;
import com.example.demo.repository.UserEntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlEvidenceRepository extends EvidenceEntityRepository, JpaRepository<EvidenceEntity, String> {

}
