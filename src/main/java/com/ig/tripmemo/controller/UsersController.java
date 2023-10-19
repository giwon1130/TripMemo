package com.ig.tripmemo.controller;

import com.ig.tripmemo.service.UsersService;
import com.ig.tripmemo.service.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService userService;

    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UsersDto> getAllUsers() {
        return userService.getAllUsers();
    }
}