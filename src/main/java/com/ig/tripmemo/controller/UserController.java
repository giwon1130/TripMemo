package com.ig.tripmemo.controller;

import com.ig.tripmemo.repository.entity.User;
import com.ig.tripmemo.service.UserService;
import com.ig.tripmemo.service.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(tags = "User API") // Swagger 태그 추가
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @ApiOperation(value = "Register a new user")
    public ResponseEntity<User> signup(
            @ApiParam(value = "User data", required = true)
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @ApiOperation(value = "Get the current user's information")
    public ResponseEntity<User> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation(value = "Get user information by username")
    public ResponseEntity<User> getUserInfo(@ApiParam(value = "Username of the user to retrieve", required = true) @PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }
}