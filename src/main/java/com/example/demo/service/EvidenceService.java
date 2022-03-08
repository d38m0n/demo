package com.example.demo.service;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.repository.EvidenceEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvidenceService {
    @Autowired
    private EvidenceEntityRepository rep;

    public EvidenceService() {

    }

    public EvidenceEntity add (EvidenceEntity ee) {
        return rep.save( ee);
    }
}
