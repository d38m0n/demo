package com.example.demo.service;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.exception.error.EvidenceNotFoundException;
import com.example.demo.exception.error.EvidenceNullPositionException;
import com.example.demo.exception.error.EvidenceRepetitionException;
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
            throw new EvidenceNullPositionException("Evidence");
        } else if (source.getPesel() == null && source.getId() == null) {
            throw new EvidenceNullPositionException("PESEL");
        } else if (source.getPesel() == null && !evidenceRepo.existsById(source.getId())) {
            throw new EvidenceNotFoundException(source.getId());
        } else if (source.getId() == null && evidenceRepo.existsByPesel(source.getPesel())) {
            throw new EvidenceRepetitionException("PESEL");
        }
        return addEntityEvidence(source);
    }

    public EvidenceEntity addNewEvidenceEntityForCompany(EvidenceEntity source) {
        if (source == null) {
            throw new EvidenceNullPositionException("Evidence");
        } else if (source.getNip() == null && source.getId() == null) {
            throw new EvidenceNullPositionException("NIP");
        } else if (source.getNip() == null && !evidenceRepo.existsById(source.getId())) {
            throw new EvidenceNotFoundException(source.getId());
        } else if (source.getId() == null && evidenceRepo.existsByNip(source.getNip())) {
            throw new EvidenceRepetitionException("NIP");
        }
        return addEntityEvidence(source);
    }

    private EvidenceEntity addEntityEvidence(EvidenceEntity source) {
        if (source.getId() == null) {
            return evidenceRepo.save(source);
        } else if (evidenceRepo.existsById(source.getId())) {
            return evidenceRepo.findById(source.getId())
                    .orElseThrow(() -> new EvidenceNotFoundException(source.getId()));
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
                .orElseThrow(() -> new EvidenceNotFoundException(" PESEL"))
                .updateFrom(source);
        return evidenceRepo.save(updatedEvidence);
    }


    public void deleteEvidence(String id) {
        if (!evidenceRepo.existsById(id)) throw new EvidenceNotFoundException(id);
        evidenceRepo.deleteById(id);
    }    //    deleted user with FK
}
