package com.uqacter.user.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import com.uqacter.user.entity.User;
import com.uqacter.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }
}
