package com.example.demo.controller;

import com.example.demo.entity.CompanyEntity;

import com.example.demo.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final  CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/companies")
    ResponseEntity<?> addNewCompany(@RequestBody CompanyEntity source) {
        logger.warn("Add Company");
        companyService.addCompany(source);
        return ResponseEntity
                .ok()
                .build();
    }

}
