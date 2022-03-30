package com.example.demo.controller;

import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.ItemEntity;
import com.example.demo.service.ClientService;
import com.example.demo.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/client")
    ResponseEntity<?> addClientEntity(@RequestBody ClientEntity source) {
        clientService.addNewClientEntity(source);
        logger.info("Crated new client");
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/clients")
    ResponseEntity<?> getAllClientEntity() {
        logger.info("Existed all clients in DB");
        return ResponseEntity
                .ok(clientService.getAllClients());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/client/{idClient}")
    ResponseEntity<?> findClientById(@PathVariable String idClient) {
        return ResponseEntity
                .ok(clientService.getClientById(idClient));
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/client/{idClient}")
    ResponseEntity<?> deleteItemById(@PathVariable String idClient) {
        clientService.deleteClientById(idClient);
        return ResponseEntity
                .ok()
                .build();
    }

}
