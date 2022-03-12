package com.example.demo.exception.error;

public class UserLoginExistException extends RuntimeException {
    public UserLoginExistException(String type) {
        super("This login is exist, change your login or restore password " + type );
    }
}
