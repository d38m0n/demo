package com.example.demo.exception.handle;

import com.example.demo.exception.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemAdvice {

    @ResponseBody
    @ExceptionHandler(ItemSNRequiredException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String itemNotFoundSerialNumberInSource(ItemSNRequiredException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ItemSNExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String itemSNisExistInDataBase(ItemSNExistException ex) {
        return ex.getMessage();
    }

}
