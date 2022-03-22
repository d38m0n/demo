package com.example.demo.exception.error;

public class CompanyNotFoundException extends  RuntimeException {
    public CompanyNotFoundException() {
        super("Not found id or id is not exist ");
    }
}
