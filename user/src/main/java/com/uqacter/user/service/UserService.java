package com.uqacter.user.service;

import java.util.List;

import com.uqacter.user.entity.User;
import com.uqacter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
