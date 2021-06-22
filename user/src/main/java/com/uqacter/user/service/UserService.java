package com.uqacter.user.service;

import com.uqacter.user.entity.User;
import com.uqacter.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long userId){
        return userRepository.findByUserId(userId);
    }
}
