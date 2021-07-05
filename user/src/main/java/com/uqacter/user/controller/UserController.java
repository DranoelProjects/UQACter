package com.uqacter.user.controller;
import org.springframework.web.bind.annotation.RestController;
import com.uqacter.user.entity.User;
import com.uqacter.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
}
