package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    public User getUserById(Long id) {
        throw new NoSuchElementException("User not found");
    }
}
