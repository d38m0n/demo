package com.example.demo.exception.error;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(){
        super("Could not find this object");
    }
}
