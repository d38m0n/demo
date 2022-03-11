package com.example.demo.service;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.model.EvidenceReadModel;
import com.example.demo.model.EvidenceUpdateModel;
import com.example.demo.repository.EvidenceEntityRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvidenceService {
    private EvidenceEntityRepository evidenceRepo;

    public EvidenceService(EvidenceEntityRepository evidenceRepo) {
        this.evidenceRepo = evidenceRepo;
    }

    public EvidenceEntity addNewEvidenceEntityForPerson(EvidenceEntity source) {

        if (source == null) {
            throw new IllegalArgumentException("Evidence cannot be null ! ! ! ");
        } else if (source.getPesel() == null && source.getId() == null) {
            throw new IllegalArgumentException("pesel cannot be null ! ! ! ");
        } else if (source.getPesel() == null && !evidenceRepo.existsById(source.getId())) {
            throw new IllegalArgumentException("Id not exist");
        } else if (source.getId() == null && evidenceRepo.existsByPesel(source.getPesel())) {
            throw new IllegalArgumentException("This PESEL exist");
        }
        return addEntityEvidence(source);
    }

    public EvidenceEntity addNewEvidenceEntityForCompany(EvidenceEntity source) {
        if (source == null) {
            throw new IllegalArgumentException("Evidence cannot be null ! ! ! ");
        } else if (source.getNip() == null && source.getId() == null) {
            throw new IllegalArgumentException("NIP cannot be null ");
        } else if (source.getNip() == null && !evidenceRepo.existsById(source.getId())) {
            throw new IllegalArgumentException("Id not exist");
        } else if (source.getId() == null && evidenceRepo.existsByNip(source.getNip())) {
            throw new IllegalArgumentException("This NIP exist");
        }
        return addEntityEvidence(source);
    }

    private EvidenceEntity addEntityEvidence(EvidenceEntity source) {
        if (source == null) {
            return evidenceRepo.save(new EvidenceEntity());
        } else if (source.getId() != null &&
                evidenceRepo.existsById(source.getId())) {
            return evidenceRepo.findById(source.getId())
                    .orElseThrow();
        } else {
            return evidenceRepo.save(source);
        }

    }

    public List<EvidenceReadModel> getAllEvidence() {
        return evidenceRepo.findAll().stream()
                .map(EvidenceReadModel::new)
                .collect(Collectors.toList());

    }

    public EvidenceEntity updateEvidenceEntityForPerson(EvidenceUpdateModel source) {

        EvidenceEntity updatedEvidence = evidenceRepo.findByPesel(source.getPesel())
                .orElseThrow(() -> new IllegalArgumentException("This PESEL not exist"))
                .updateFrom(source);
        return evidenceRepo.save(updatedEvidence);
    }

    //    deleted user with FK
    public void deleteEvidence(String id) {
        evidenceRepo.deleteById(id);
    }
}
