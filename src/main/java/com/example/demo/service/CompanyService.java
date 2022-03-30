package com.example.demo.service;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.entity.EvidenceEntity;
import com.example.demo.exception.error.CompanyNotFoundException;
import com.example.demo.model.CompanyReadModel;
import com.example.demo.model.CompanyUpdateModel;
import com.example.demo.repository.CompanyEntityRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private EvidenceService evidenceService;
    private UserService userServ;
    private ClientService clientSer;
    private ItemService itemSer;
    private CompanyEntityRepository companyRep;

    public CompanyService(EvidenceService evidenceService,
                          CompanyEntityRepository companyRep,
                          UserService userServ,
                          ClientService clientSer,
                          ItemService itemSer) {
        this.evidenceService = evidenceService;
        this.companyRep = companyRep;
        this.userServ = userServ;
        this.clientSer = clientSer;
        this.itemSer = itemSer;
    }

    public CompanyEntity addCompany(CompanyEntity ce) {

        EvidenceEntity addEvidence = evidenceService
                .addNewEvidenceEntityForCompany(ce.getEvidence_id());
        ce.setEvidence_id(addEvidence);
        return companyRep.save(ce);
    }

    public CompanyEntity addClientToCompany(String idClient, String idCompany) {
        return companyRep.save(
                companyRep.findById(idCompany)
                        .orElseThrow(CompanyNotFoundException::new)
                        .addClientToCompany(clientSer.getClientById(idClient)));
    }

    public CompanyEntity addUserToCompany(String idUser, String idCompany) {
        return companyRep.save(
                companyRep.findById(idCompany)
                        .orElseThrow(CompanyNotFoundException::new)
                        .addUserToCompany(userServ.findUserByIdEntity(idUser)));
    }

    public CompanyEntity addItemToCompany(String idItem, String idCompany) {
        return companyRep.save(
                companyRep.findById(idCompany)
                        .orElseThrow(CompanyNotFoundException::new)
                        .addItemToCompany(itemSer.getItemEntityById(idItem)));
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
                    .orElseThrow(CompanyNotFoundException::new)
                    .updateFrom(source);
            companyRep.save(companyUpdate);
        } else {
            throw new CompanyNotFoundException();
        }
    }

    public void deletedUserWithCompany(String idUser,  String idCompany) {
        companyRep.save(
                companyRep.findById(idCompany)
                        .orElseThrow(CompanyNotFoundException::new)
                        .deleteUserWithCompany(userServ.findUserByIdEntity(idUser)));

    }

    public void deletedItemWithCompany(String idItem, String idCompany) {
        companyRep.save(
                companyRep.findById(idCompany)
                        .orElseThrow(CompanyNotFoundException::new)
                        .deleteItemWithCompany(itemSer.getItemEntityById(idItem)));

    }

    public void deletedClientWithCompany(String idClient, String idCompany) {
        companyRep.save(
                companyRep.findById(idCompany)
                        .orElseThrow(CompanyNotFoundException::new)
                        .deleteClientWithCompany(clientSer.getClientById(idClient)));
    }
}
