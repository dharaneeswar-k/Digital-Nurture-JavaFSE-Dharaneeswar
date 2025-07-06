package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User(userId, "John");
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Act
        User result = userService.getUserById(userId);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals(userId, result.getId());
    }

    @Test
    void testGetUserById_UserNotFound() {
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        User result = userService.getUserById(userId);

        assertNull(result);
    }
}
