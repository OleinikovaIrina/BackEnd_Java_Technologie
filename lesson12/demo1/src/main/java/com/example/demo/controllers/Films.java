package com.example.demo.controllers;

public class Films {

    String filmName;
   String director;

    public Films(String filmName, String director) {
        this.filmName = filmName;
        this.director = director;
    }

    public Films() {
    }

    public String getFilmName() {
        return filmName;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Films{" +
                "filmName='" + filmName + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}

