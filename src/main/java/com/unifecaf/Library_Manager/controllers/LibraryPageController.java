package com.unifecaf.Library_Manager.controllers;

import com.unifecaf.Library_Manager.models.Book;
import com.unifecaf.Library_Manager.services.LibraryDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryPageController {

    private final LibraryDatabase libraryDatabase;

    public LibraryPageController(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", libraryDatabase.getAllBooks());
        return "books"; // Thymeleaf page: templates/books.html
    }

    @GetMapping("/books/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm"; // templates/bookForm.html
    }

    @PostMapping("/books")
    public String createBook(@ModelAttribute Book book) {
        libraryDatabase.saveBook(book);
        return "redirect:/books";
    }
}
