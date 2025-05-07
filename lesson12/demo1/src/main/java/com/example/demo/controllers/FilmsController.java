package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmsController {

    @RequestMapping(value = "/films", method = RequestMethod.GET)

    public List<Films> getFilms() {

        List<Films> films = new ArrayList<Films>();
        films.add(new Films("Inception", "Christopher Nolan"));
        films.add(new Films("Pulp Fiction", "Quentin Tarantino"));
        films.add(new Films("The Grand Budapest Hotel", "Wes Anderson"));

    return films;}

}
