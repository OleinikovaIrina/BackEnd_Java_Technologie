package com.example.demo.controllers;

public class Books {

    String bookName;
    String author;

    public Books(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Books() {
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
