package com.example.demo.exception.error;


public class ClientNofFoundException extends RuntimeException{
    public ClientNofFoundException() {
        super("Not Found this Client");
    }
}
