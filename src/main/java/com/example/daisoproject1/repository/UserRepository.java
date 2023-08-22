package com.example.daisoproject1.repository;

import com.example.daisoproject1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByName(String name);

        public User findByNameAndAndPassword(String name, String password);

    }


