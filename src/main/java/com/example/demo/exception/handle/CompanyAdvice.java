package com.example.demo.exception.handle;

import com.example.demo.exception.error.EvidenceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CompanyAdvice {

    @ResponseBody
    @ExceptionHandler(ClassNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String evidenceNotFoundHandler(EvidenceNotFoundException ex) {
        return ex.getMessage();
    }
}
