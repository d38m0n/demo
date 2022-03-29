package com.example.demo.exception.error;

public class ItemSNRequiredException extends  RuntimeException {
    public ItemSNRequiredException() {
        super("Serial number is needed to created item");
    }
}
