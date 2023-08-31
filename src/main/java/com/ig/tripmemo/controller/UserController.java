package com.ig.tripmemo.controller;

import com.ig.tripmemo.common.ApiResponse;
import com.ig.tripmemo.repository.entity.Users;
import com.ig.tripmemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "User Management System")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "View a list of available users", response = List.class)
    @GetMapping("/")
    public ApiResponse<List<Users>> getAllUsers() {
        return ApiResponse.setSuccessOkResponse(userService.getAllUsers());
    }

    @ApiOperation(value = "Get a user by Id")
    @GetMapping("/{id}")
    public ApiResponse<Users> getUserById(@PathVariable Long id) {
        Optional<Users> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ApiResponse.setSuccessOkResponse(user.get());
        } else {
            return ApiResponse.setNotFoundResponse();
        }
    }

    @ApiOperation(value = "Add a user")
    @PostMapping("/")
    public ApiResponse<Users> createUser(@RequestBody Users user) {
        return ApiResponse.setSuccessCreatedResponse(userService.createUser(user));
    }

    @ApiOperation(value = "Update a user")
    @PutMapping("/{id}")
    public ApiResponse<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        user.setId(id);
        return ApiResponse.setSuccessOkResponse(userService.updateUser(user));
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.setSuccessOkResponse(null);
    }
}

