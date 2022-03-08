package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserReadModel;
import com.example.demo.model.UserWriteModel;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    ResponseEntity<?> addNewUser(@RequestBody UserWriteModel ue) {
        userService.addNewUser(ue);
        logger.info("Crated user: " + ue.getLogin());

        return ResponseEntity
                .ok()
                .build();
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
    ResponseEntity<?> updateUser(@RequestBody @Valid UserEntity userEntity) {
        if (userService.update(userEntity)) {
            logger.info("User " + userEntity.getLogin() + " is update");
            return ResponseEntity
                    .noContent()
                    .build();
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/users/{idUser}")
    ResponseEntity<?> deleteUser(@PathVariable String idUser) {
        logger.info("Some body want delete USER");
        if (userService.delete(idUser)) {
            logger.warn("User deleted by id " + idUser);
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
