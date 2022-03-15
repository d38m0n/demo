package com.example.demo.controller;

import com.example.demo.entity.CompanyEntity;

import com.example.demo.model.CompanyUpdateModel;
import com.example.demo.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final CompanyService companySer;

    public CompanyController(CompanyService companySer) {
        this.companySer = companySer;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/companies")
    ResponseEntity<?> addNewCompany(@RequestBody CompanyEntity source) {
        logger.warn("Add Company");
        companySer.addCompany(source);
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/companies/{idUser}")
    ResponseEntity<?> addUserToCompany(@PathVariable String idUser,
                                       @RequestBody CompanyEntity source) {
        logger.warn("Add user to company");
        companySer.addUserToCompany(idUser ,source);
        return ResponseEntity
                .ok()
                .build();
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/companies/{idUser}")
    ResponseEntity<?> deleteUserWithCompany(@PathVariable String idUser,
                                       @RequestBody CompanyEntity source) {
        logger.warn("Delete user with company");
        companySer.deletedUserWithCompany(idUser ,source);
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/companies")
    ResponseEntity<?> getAllCompanies() {
        logger.warn("Get all Companies");
        return ResponseEntity
                .ok(companySer.getAllCompanies());
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            path = "/companies")
    ResponseEntity<?> getAllCompanies(@RequestBody CompanyUpdateModel source) {
        logger.warn("Update company" );
        companySer.updateCompanyById(source);
        return ResponseEntity
                .ok()
                .build();
    }

}
