package com.example.demo.service;

import com.example.demo.entity.ClientEntity;
import com.example.demo.exception.error.ClientNofFoundException;
import com.example.demo.model.ClientReadModel;
import com.example.demo.repository.ClientEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    private ClientEntityRepository clientRepository;
    private EvidenceService evidenceService;
    private ModelMapper modelMapper;

    public ClientService(ClientEntityRepository clientRepository,
                         EvidenceService evidenceService) {
        this.clientRepository = clientRepository;
        this.evidenceService = evidenceService;
        this.modelMapper = new ModelMapper();
    }

    public void addNewClientEntity(ClientEntity source) {

        source.setEvidence_id(evidenceService
                .addNewEvidenceEntityForCompany(source.getEvidence_id()));
        clientRepository.save(source);
    }


    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientEntity getClientById(String id) {
        return clientRepository.findById(id).orElseThrow(ClientNofFoundException::new);
    }

    public ClientReadModel getClientModelById(String id) {
        return modelMapper.map(clientRepository.findById(id)
                .orElseThrow(ClientNofFoundException::new), ClientReadModel.class);
    }


    public void deleteClientById(String id) {
        if (!clientRepository.existsById(id)) throw new ClientNofFoundException();
        clientRepository.deleteById(id);
    }
}
