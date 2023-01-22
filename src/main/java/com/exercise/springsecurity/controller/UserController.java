package com.exercise.springsecurity.controller;

import com.exercise.springsecurity.dto.UserDto;
import com.exercise.springsecurity.entity.User;
import com.exercise.springsecurity.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
//    @PreAuthorize("hasAuthority(ROLE_ADMIN)")
    public UserDto addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
