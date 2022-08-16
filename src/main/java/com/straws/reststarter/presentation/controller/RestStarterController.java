package com.straws.reststarter.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestStarterController {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
}
