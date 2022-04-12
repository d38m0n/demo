package com.example.demo.controller;

import com.example.demo.model.UserWriteModel;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String apiHome(Model model) {
        model.addAttribute("user", new UserWriteModel());
        return "admin-panel";
    }

    @PostMapping(params = "addUser")
    String addUser(@ModelAttribute("user") UserWriteModel current,
                   Model model) {
        userService.addNewUser(current);
        model.addAttribute("user", new UserWriteModel());

        return "admin-panel";
    }
}
