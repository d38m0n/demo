package com.example.demo.controller;

import com.example.demo.entity.JobsheetEntity;
import com.example.demo.service.JobsheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class JobsheetController {
    private static final Logger logger = LoggerFactory.getLogger(JobsheetController.class);
    private JobsheetService jobsheetService;

    public JobsheetController(JobsheetService jobsheetService) {
        this.jobsheetService = jobsheetService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/jobsheet")
    ResponseEntity<?> addJobsheetEntity(@RequestBody JobsheetEntity source) {
        jobsheetService.addNewJobsheetEntity(source);
        logger.info("Crated new jobsheet");
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            path = "/jobsheet/{idJobsheet}/{idItem}")
    ResponseEntity<?> addItemToJobsheetEntity(@PathVariable String idJobsheet,
                                              @PathVariable String idItem) {
        jobsheetService.addItemToJobsheetEntity(idJobsheet,idItem);
        logger.info("Add item to job sheet");
        return ResponseEntity
                .ok()
                .build();
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/jobsheet/{idJobsheet}/{idItem}")
    ResponseEntity<?> deleteItemWithJobsheetEntity(@PathVariable String idJobsheet,
                                              @PathVariable String idItem) {
        jobsheetService.deleteItemWithJobsheetEntity(idJobsheet,idItem);
        logger.info("Delete item with job sheet");
        return ResponseEntity
                .ok()
                .build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/jobsheets")
    ResponseEntity<?> getAllJobsheetsEntity() {
        logger.info("Existed all job sheet in DB");
        return ResponseEntity
                .ok(jobsheetService.getAllJobsheets());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/jobsheet/{idJobsheet}")
    ResponseEntity<?> findJobsheetById(@PathVariable String idJobsheet) {
        return ResponseEntity
                .ok(jobsheetService.getJobsheetById(idJobsheet));
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/jobsheet/{idJobsheet}")
    ResponseEntity<?> deleteJobsheetById(@PathVariable String idJobsheet) {
        jobsheetService.deleteJobsheetById(idJobsheet);
        return ResponseEntity
                .ok()
                .build();
    }

}
