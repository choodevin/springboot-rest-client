package com.main.api.service;

import com.main.api.model.LoginRequest;
import com.main.api.model.Users;
import com.main.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<Users> login(LoginRequest loginRequest) throws NoSuchAlgorithmException {
        Optional<Users> usersOptional;

        if (loginRequest != null) {
            usersOptional = usersRepository.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword());

            if (usersOptional.isPresent()) {
                LocalDateTime now = LocalDateTime.now();
                Users currentUser = usersOptional.get();

                currentUser.setToken(String.valueOf(UUID.randomUUID()));
                currentUser.setTokenExpire(now.plusMinutes(1));
                currentUser = usersRepository.saveAndFlush(currentUser);

                return new ResponseEntity<>(currentUser, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
