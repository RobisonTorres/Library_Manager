package com.unifecaf.Library_Manager.controllers;

import com.unifecaf.Library_Manager.models.Book;
import com.unifecaf.Library_Manager.services.LibraryDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LibraryApiController {

    private final LibraryDatabase libraryDatabase;

    public LibraryApiController(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }
    @GetMapping("/")
    public String helloWorld () {

        return "Hello World";
    }
    @GetMapping("/books")
    public Iterable<Book> getAllBooks () {

        return libraryDatabase.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Book getSpecific (@PathVariable Integer id) {
        Book book = libraryDatabase.getSpecific(id);
        if (book == null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {return book;}
    }
}