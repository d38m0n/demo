package com.example.demo.exception.error;

public class ItemNotFoundIdException extends  RuntimeException {
    public ItemNotFoundIdException() {
        super("Not found this id ;(");
    }
}
