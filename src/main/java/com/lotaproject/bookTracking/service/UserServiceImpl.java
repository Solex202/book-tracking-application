package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.LoginDto;
import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.exception.BookApplicationException;
import com.lotaproject.bookTracking.model.MyUser;
import com.lotaproject.bookTracking.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public String registerUser(RegisterUserDto dto) {
        log.info("GOT HERE ------->");

        MyUser myUser = new MyUser();
        if(userRepository.existsByUsername(dto.getUsername())){
            throw new BookApplicationException("User already exists");
        }
        myUser.setUsername(dto.getUsername());
        myUser.setPassword(dto.getPassword());
        myUser.setLoginStatus(false);

//        String passwordEncoder = passwordEncoder().encode(dto.getPassword());
//        log.info("ENCODED PASSWORD -------------------> {} ", passwordEncoder);
//        myUser.setPassword(passwordEncoder);

        userRepository.save(myUser);
        return "Registration successful";
  
    }

    @Override
    public String login(LoginDto dto) {
        MyUser user = userRepository.findByUsername(dto.getUsername()).orElseThrow(()-> new BookApplicationException("User not found"));

            if(! user.getPassword().matches(dto.getPassword())){
                throw new BookApplicationException("Incorrect password");
            }

            user.setLoginStatus(true);

            userRepository.save(user);

            return "Login Successful";
    }


}
