package com.example.springbootpractice.validationpractice.controller;


import com.example.springbootpractice.validationpractice.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/validation")
    public ResponseEntity<User> validate(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
