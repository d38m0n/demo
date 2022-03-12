package com.example.demo.exception.handle;

import com.example.demo.exception.error.EvidenceNotFoundException;
import com.example.demo.exception.error.EvidenceNullPositionException;
import com.example.demo.exception.error.EvidenceRepetitionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EvidenceAdvice {

    @ResponseBody
    @ExceptionHandler(EvidenceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String evidenceNotFoundHandler(EvidenceNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EvidenceNullPositionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String evidenceNullPositionHandler(EvidenceNullPositionException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EvidenceRepetitionException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String evidenceRepetitionHandler(EvidenceRepetitionException ex) {
        return ex.getMessage();
    }
}
