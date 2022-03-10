package com.example.demo.controller;

import com.example.demo.model.EvidenceWriteModel;
import com.example.demo.service.EvidenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EvidenceController {
    public static final Logger logger = LoggerFactory.getLogger(EvidenceController.class);
    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/evidence-user")
    ResponseEntity<?> addUserEvidence(@RequestBody EvidenceWriteModel source) {
        evidenceService.addNewEvidenceEntityForPerson(source);
        logger.info("Crated new evidence ");
        return ResponseEntity
                .ok()
                .build();

    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/evidence-user")
    ResponseEntity<?> updateUserEvidence(@RequestBody EvidenceWriteModel source) {
        evidenceService.updateEvidenceEntityForPerson(source);
        logger.info("Update evidence " + source.getPesel());
        return ResponseEntity
                .ok()
                .build();

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/evidence")
    ResponseEntity<?> getAllEvidence() {
        logger.warn("Get all evidence !!!");
        return ResponseEntity
                .ok(evidenceService.getAllEvidence());

    }
}
