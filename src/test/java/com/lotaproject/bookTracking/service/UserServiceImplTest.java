package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.model.MyUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void testThatCanRegisterUser(){
        RegisterUserDto dto = new RegisterUserDto();
        dto.setPassword("lotachi123");
        dto.setUsername("lolo");

        String response =  userService.registerUser(dto);
    }

}