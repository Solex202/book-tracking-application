package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.LoginDto;
import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.exception.BookApplicationException;
import com.lotaproject.bookTracking.model.MyUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void testThatCanRegisterUser(){
        RegisterUserDto dto = new RegisterUserDto();
        dto.setPassword("lotachi12333");
        dto.setUsername("lolo");


        String response =  userService.registerUser(dto);
        assertAll(
                ()-> assertNotNull(dto),
                ()-> assertEquals("lolo", dto.getUsername()),
                ()-> assertThat(response, is("Registration successful"))

        );
    }

    @Test
    void userCanLogin(){
        LoginDto dto = new LoginDto();

        dto.setUsername("lotachi12333");
        dto.setPassword("lolo");

        String response = userService.login(dto);

        assertThat(response, is("Login successful"));
    }

    @Test
    void userCanLogin_throwException(){
        LoginDto dto = new LoginDto();

        dto.setUsername("lotachi123");
        dto.setPassword("lolo");

        assertThrows(BookApplicationException.class, ()->userService.login(dto));

    }

}