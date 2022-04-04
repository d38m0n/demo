package com.example.demo.exception.handle;

import com.example.demo.exception.error.ItemNotFoundIdException;
import com.example.demo.exception.error.ItemSNExistException;
import com.example.demo.exception.error.ItemSNRequiredException;
import com.example.demo.exception.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String canNotFoundThatIdHandler(NotFoundException ex) {
        return ex.getMessage();
    }


}
