package com.example.demo.controller;

import com.example.demo.model.UserReadModel;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.model.UserWriteModel;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/users")
    ResponseEntity<?> addNewUser(@RequestBody UserWriteModel userWriteModel) {
        userService.addNewUser(userWriteModel);
        logger.info("Crated user: " + userWriteModel.getLogin());
        return ResponseEntity
                .ok()
                .build();

    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            path = "/users")
    ResponseEntity<?> changePasswordByLoginAndLastPassword(@RequestBody UserUpdateModel source) {
        userService.changPassword(source);
        logger.info("Password changed: " + source.getLogin());
        return ResponseEntity
                .noContent()
                .build();

    }

    @RequestMapping(
        method = RequestMethod.GET,
            path = "/user/{idUser}"
    )
    ResponseEntity<?> findUserById(@PathVariable String idUser) {
        return ResponseEntity.ok(userService.findUserById(idUser));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/users",
            params = {"!sort", "!page", "!size"})
    ResponseEntity<List<UserReadModel>> getAllUsers() {
        logger.warn("Exposing all USERS !! !! !!");
        return ResponseEntity
                .ok(userService.findAllUsers());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/users")
    ResponseEntity<List<UserReadModel>> getAllUsersSort(Pageable pageable) {
        logger.warn("Exposing all User by pageable" + pageable.toString());
        return ResponseEntity
                .ok(userService.findAllBySortedUsers(pageable));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/users")
    ResponseEntity<?> updateUserById(@RequestBody @Valid UserUpdateModel source) {
        userService.updateUserByModelUpdate(source);
        logger.info("User update");
        return ResponseEntity
                .noContent()
                .build();

    }
}
