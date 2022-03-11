package com.example.demo.service;

import com.example.demo.entity.EvidenceEntity;
import com.example.demo.model.EvidenceReadModel;
import com.example.demo.model.EvidenceWriteModel;
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

    public EvidenceEntity addNewEvidenceEntityForPerson(EvidenceWriteModel source) {
        if (source == null || source.getPesel() == null) {
            throw new IllegalArgumentException("pesel cannot be null ! ! ! ");
        }
        if (evidenceRepo.existsByPesel(source.getPesel())) {
            throw new IllegalArgumentException("This PESEL exist");
        }
        return evidenceRepo.save(source.getEntityEvidence());
    }

    public EvidenceEntity addNewEvidenceEntityForCompany(EvidenceWriteModel source) {
        if (source == null) {
            throw new IllegalArgumentException("NIP cannot be null ! ! ! ");
        }
        if (evidenceRepo.existsByNip(source.getNip())) {
            throw new IllegalArgumentException("This NIP exist");
        }
        return evidenceRepo.save(new EvidenceEntity().updateFrom(source));
    }

    public List<EvidenceReadModel> getAllEvidence() {
        return evidenceRepo.findAll().stream()
                .map(EvidenceReadModel::new)
                .collect(Collectors.toList());

    }

    public EvidenceEntity updateEvidenceEntityForPerson(EvidenceWriteModel source) {

        EvidenceEntity updatedEvidence = evidenceRepo.findByPesel(source.getPesel())
                .orElseThrow(() -> new IllegalArgumentException("This PESEL not exist"))
                .updateFrom(source);
        return evidenceRepo.save(updatedEvidence);
    }
//    deleted user with FK
    public void deleteEvidence(String id){
        evidenceRepo.deleteById(id);
    }
}
