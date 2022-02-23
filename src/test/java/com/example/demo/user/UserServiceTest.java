package com.example.demo.user;

import com.example.demo.UtilTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private final UtilTestData utilTestData = new UtilTestData();

    @Test
    void getUserAddress() {

        UserEntity user = utilTestData.generateUserMockData();
        when(userRepository.findById("0")).thenReturn(Optional.of(user));

        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        UserAddressResponseModel result = userService.getUserAddress("0");

        assertEquals(user.getAddress(),result.getAddress());
    }

    @Test
    void getUserById() {

        UserEntity user = utilTestData.generateUserMockData();
        when(userRepository.findById("0")).thenReturn(Optional.of(user));

        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        UserEntity result = userService.getUserById("0");

        assertEquals(user.getName(),result.getName());

    }
}