package com.example.demo.exception.error;

public class UserNotAuthorizationException extends RuntimeException {

    public UserNotAuthorizationException(String idUser){
        super("Could not authorization");
    }
}
