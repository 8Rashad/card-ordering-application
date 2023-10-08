package com.example.cardorderingapplicationg.controller;

import com.example.cardorderingapplicationg.model.CardRequest;
import com.example.cardorderingapplicationg.model.UserRequest;
import com.example.cardorderingapplicationg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest.toString());
        userService.saveUser(userRequest);


    }
}