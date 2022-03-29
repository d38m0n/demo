package com.example.demo.exception.error;

public class ItemSNExistException extends  RuntimeException {
    public ItemSNExistException() {
        super("This serial number exist in your data base");
    }
}
