package com.main.api.controller;

import com.main.api.constants.ResourcePath;
import com.main.api.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ResourcePath.DEFAULT_ENTRY)
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping(value = ResourcePath.GET_TODO_LIST_BY_ID)
    public ResponseEntity<String> getTodoListById(@PathVariable("id") String id) {
        return mainService.getTodoListById(UUID.fromString(id));
    }
}
