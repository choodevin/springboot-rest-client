package com.main.api.service;

import com.main.api.model.Todo;
import com.main.api.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MainService {
    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<String> getTodoListById(UUID id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        return todoOptional.map(value -> new ResponseEntity<>(value.getDscp(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND));
    }
}
