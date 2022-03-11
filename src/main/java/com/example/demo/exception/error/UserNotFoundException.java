package com.example.demo.exception.error;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException (String idUser){
        super("Could not find user by: "+ idUser);
    }
}
