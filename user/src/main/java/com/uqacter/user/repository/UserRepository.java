package com.uqacter.user.repository;

import org.springframework.stereotype.Repository;
import com.uqacter.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
}
