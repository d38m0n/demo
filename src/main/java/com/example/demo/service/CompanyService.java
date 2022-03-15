package com.example.demo.service;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.entity.EvidenceEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.CompanyReadModel;
import com.example.demo.model.CompanyUpdateModel;
import com.example.demo.model.UserReadModel;
import com.example.demo.repository.CompanyEntityRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private EvidenceService evidenceService;
    private UserService userServ;
    private CompanyEntityRepository companyRep;

    public CompanyService(EvidenceService evidenceService,
                          CompanyEntityRepository companyRep, UserService userServ) {
        this.evidenceService = evidenceService;
        this.companyRep = companyRep;
        this.userServ = userServ;
    }

    public CompanyEntity addCompany(CompanyEntity ce) {

        EvidenceEntity addEvidence = evidenceService
                .addNewEvidenceEntityForCompany(ce.getEvidence_id());

        ce.setEvidence_id(addEvidence);
        return companyRep.save(ce);
    }

    public CompanyEntity addUserToCompany(String idUser, CompanyEntity source) {
        UserEntity userEntity = userServ.findUserByIdEntity(idUser);

        CompanyEntity companyEntity = companyRep.findById(source.getId())
                .orElseThrow(IllegalArgumentException::new);// to change

        companyEntity.addUserToCompany(userEntity);

        return companyRep.save(companyEntity);
    }

    public List<CompanyReadModel> getAllCompanies() {
        return companyRep.findAll()
                .stream()
                .map(CompanyReadModel::new)
                .collect(Collectors.toList());
    }


    public void updateCompanyById(CompanyUpdateModel source) {
        if (source.getId() != null) {
            CompanyEntity companyUpdate = companyRep.findById(source.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Not found this id")) // to change
                    .updateFrom(source);
            companyRep.save(companyUpdate);
        } else {
            throw new IllegalArgumentException("Not found id in body ");
        }
    }

    public void deletedUserWithCompany(String idUser, CompanyEntity source) {
        UserEntity userFound = userServ.findUserByIdEntity(idUser);
        CompanyEntity company = companyRep.findById(source.getId())
                .orElseThrow(IllegalAccessError::new);// to change

        company.deleteUserWithCompany(userFound);
        companyRep.save(company);

    }
}
