package com.example.demo.controllers;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoRestController {
    @RequestMapping(value = "/books", method = RequestMethod.GET)

    public List<Books> getBooks() {
        List<Books> books = new ArrayList<>();
        books.add(new Books("1984", "George Orwell"));
        books.add(new Books("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Books("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Books("Pride and Prejudice", "Jane Austen"));
        books.add(new Books("Moby-Dick", "Herman Melville"));
        return books;
    }

}
