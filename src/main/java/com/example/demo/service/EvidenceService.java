package com.example.demo.service;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.repository.EvidenceEntityRepository;

import org.springframework.stereotype.Service;

@Service
public class EvidenceService {
    private EvidenceEntityRepository evidenceRepo;

    public EvidenceService(EvidenceEntityRepository evidenceRepo) {
        this.evidenceRepo = evidenceRepo;
    }

    public EvidenceEntity addEvidence(EvidenceEntity ee) {
        return evidenceRepo.save(ee);
    }
}
