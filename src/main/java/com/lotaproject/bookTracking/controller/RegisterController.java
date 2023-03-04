package com.lotaproject.bookTracking.controller;

import com.lotaproject.bookTracking.dto.LoginDto;
import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.model.MyUser;
import com.lotaproject.bookTracking.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserDto registerUserDto){
        log.info("i got here");
       String response = userService.registerUser(registerUserDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        String response = userService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
