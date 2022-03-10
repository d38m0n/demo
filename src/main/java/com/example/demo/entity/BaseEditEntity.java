package com.example.demo.entity;

import com.example.demo.repository.EvidenceEntityRepository;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
abstract class BaseEditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @OneToOne()
    @JoinColumn(name = "evidence_id")
    private EvidenceEntity evidence_id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;


    public BaseEditEntity() {
    }

    public String getId() {
        return id;
    }

    public EvidenceEntity getEvidence_id() {
        return evidence_id;
    }

    public void setEvidence_id(EvidenceEntity evidence_id) {
        this.evidence_id = evidence_id;
    }


    @PrePersist
    void dateCreated() {
        createdOn = LocalDateTime.now();

    }

    @PreUpdate
    void lastUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
