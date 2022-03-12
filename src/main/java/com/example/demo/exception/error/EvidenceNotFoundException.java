package com.example.demo.exception.error;

public class EvidenceNotFoundException extends  RuntimeException{
    public EvidenceNotFoundException (String id){
        super("Could not find evidence with" + id);
    }
}
