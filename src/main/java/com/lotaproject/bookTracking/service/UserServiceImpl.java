package com.lotaproject.bookTracking.service;

import com.lotaproject.bookTracking.dto.LoginDto;
import com.lotaproject.bookTracking.dto.RegisterUserDto;
import com.lotaproject.bookTracking.exception.BookApplicationException;
import com.lotaproject.bookTracking.model.AppRole;
import com.lotaproject.bookTracking.model.MyUser;
import com.lotaproject.bookTracking.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public String registerUser(RegisterUserDto dto) {
        log.info("GOT INTO SERVICE ");

        var myUser = new MyUser();
        if(userRepository.existsByUsername(dto.getUsername())){
            throw new BookApplicationException("User already exists");
        }

        myUser.setUsername(dto.getUsername());
        myUser.setRole(String.valueOf(AppRole.USER));
        myUser.setPassword(dto.getPassword());
        myUser.setLoginStatus(false);

        userRepository.save(myUser);

        log.info("ENCRYPTED PASSWORD {}",myUser.getPassword() );
        return "Registration successful";
  
    }

    @Override
    public String login(LoginDto dto) {
        var user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(()-> new BookApplicationException("User not found"));

            if(! user.getPassword().matches(dto.getPassword())){
                throw new BookApplicationException("Incorrect password");
            }

            user.setLoginStatus(true);
            userRepository.save(user);

            return "Login Successful";
    }

}
