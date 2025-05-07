package de.ait.demo20250517_1.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Film {
    private String title;
    private int year;
}