package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.model.MyUser;
import com.lotaproject.bookTracking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public String registerUser(RegisterUserDto dto) {
        log.info("GOT HERE ------->");

        MyUser myUser = new MyUser();
        myUser.setUsername(dto.getUsername());

        String passwordEncoder = passwordEncoder().encode(dto.getPassword());
        log.info("ENCODED PASSWORD -------------------> {} ", passwordEncoder);
        myUser.setPassword(passwordEncoder);

        userRepository.save(myUser);
        return "Registration successful";

    }
}
