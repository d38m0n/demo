package com.example.demo.exception.error;

public class EvidenceNullPositionException extends RuntimeException {
    public EvidenceNullPositionException(String text) {
        super(text + " can not be null");
    }
}
