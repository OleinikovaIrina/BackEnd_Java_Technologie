package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TimeController {

    @RequestMapping(value = "/now", method = RequestMethod.GET)

    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }


}
