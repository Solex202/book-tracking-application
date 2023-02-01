package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.model.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void testThatCanRegisterUser(){
        RegisterUserDto dto = new RegisterUserDto();
        dto.setPassword("lotachi123");
        dto.setUsername("lolo");

        userService.registerUser(dto);
    }

}