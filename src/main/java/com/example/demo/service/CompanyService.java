package com.example.demo.service;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.repository.CompanyEntityRepository;
import com.example.demo.repository.EvidenceEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private EvidenceEntityRepository evidenceRep;
    private CompanyEntityRepository companyRep;

    public CompanyService(EvidenceEntityRepository evidenceRep, CompanyEntityRepository companyRep) {
        this.evidenceRep = evidenceRep;
        this.companyRep = companyRep;
    }

    public CompanyEntity addCompay(CompanyEntity ce){
        ce.setEvidence_id(evidenceRep.save(ce.getEvidence_id()));
        return companyRep.save(ce);
    }


}
