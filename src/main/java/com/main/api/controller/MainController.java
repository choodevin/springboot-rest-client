package com.main.api.controller;

import com.main.api.constants.ResourcePath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourcePath.DEFAULT_ENTRY)
public class MainController {

    @GetMapping(value = ResourcePath.TEST)
    public String test() {
        return "test";
    }
}
