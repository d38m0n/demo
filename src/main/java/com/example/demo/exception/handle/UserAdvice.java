package com.example.demo.exception.handle;

import com.example.demo.exception.error.UserLoginExistException;
import com.example.demo.exception.error.UserNotAuthorizationException;
import com.example.demo.exception.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class UserAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserLoginExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String userConflictLoginHandler(UserLoginExistException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotAuthorizationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String userNotAuthorizationHandler(UserNotAuthorizationException ex) {
        return ex.getMessage();
    }
}
