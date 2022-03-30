package com.example.demo.exception.handle;

import com.example.demo.exception.error.ClientNofFoundException;
import com.example.demo.exception.error.ItemNotFoundIdException;
import com.example.demo.exception.error.ItemSNExistException;
import com.example.demo.exception.error.ItemSNRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientAdvice {


    @ResponseBody
    @ExceptionHandler(ClientNofFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String clientNotFoundIdExceptionHandler(ClientNofFoundException ex) {
        return ex.getMessage();
    }

}
