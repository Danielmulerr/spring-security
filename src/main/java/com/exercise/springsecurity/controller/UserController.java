package com.exercise.springsecurity.controller;

import com.exercise.springsecurity.dto.AuthRequest;
import com.exercise.springsecurity.dto.UserDto;
import com.exercise.springsecurity.entity.User;
import com.exercise.springsecurity.services.JwtService;
import com.exercise.springsecurity.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/test-user")
//    @PreAuthorize("hasAuthority(ROLE_ADMIN)")
    public UserDto addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/auth")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        var authResult = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authRequest.getUsername(), authRequest.getPassword()))
                .isAuthenticated();
        if (authResult)
            return jwtService.generateToken(authRequest.getUsername());
        else
            throw new RuntimeException("Unable to login! Please check username and password.");
    }
}
