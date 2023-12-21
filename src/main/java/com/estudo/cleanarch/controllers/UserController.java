package com.estudo.cleanarch.controllers;

import com.estudo.cleanarch.dtos.UserDto;
import com.estudo.cleanarch.models.UserModel;
import com.estudo.cleanarch.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void create(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/user")
    public List<UserModel> findAll() {
        return userService.findAll();
    }
}
