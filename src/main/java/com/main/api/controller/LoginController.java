package com.main.api.controller;

import com.main.api.constants.ResourcePath;
import com.main.api.model.LoginRequest;
import com.main.api.model.Users;
import com.main.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(ResourcePath.LOGIN_ENTRY)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = ResourcePath.LOGIN)
    public ResponseEntity<Users> login(@RequestBody LoginRequest loginRequest) throws NoSuchAlgorithmException {
        return loginService.login(loginRequest);
    }
}
