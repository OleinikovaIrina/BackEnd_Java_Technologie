package de.ait.demo20250517_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Book {
    private Author author;
    private String title;
}