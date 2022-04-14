package com.example.demo.entity;

import com.example.demo.model.EvidenceReadModel;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEditEntity {

    @OneToOne()
    @JoinColumn(name = "evidence_id")
    private EvidenceEntity evidence_id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;


    public BaseEditEntity() {
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
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
