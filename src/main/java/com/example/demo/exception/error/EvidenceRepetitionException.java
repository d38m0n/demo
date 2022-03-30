package com.example.demo.exception.error;



public class EvidenceRepetitionException extends RuntimeException {
    public EvidenceRepetitionException(String type){
        super("Can not repetition " + type);
    }
}
