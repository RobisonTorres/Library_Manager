package com.unifecaf.Library_Manager.controllers;

import com.unifecaf.Library_Manager.models.Book;
import com.unifecaf.Library_Manager.services.LibraryDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class LibraryPageController {

    private final LibraryDatabase libraryDatabase;

    public LibraryPageController(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        // The Model parameter is used to pass data from the backend (controller) to the frontend (view).
        // Here, "all_books" is a key (like a variable name) that receives the data from the function
        // and passes it to the frontend (view) as a model attribute.
        model.addAttribute("all_books", libraryDatabase.getAllBooks());
        return "books"; // returns page: templates/books.html
    }

    @GetMapping("/books/new")
    public String showCreateForm(Model model) {
        // Here, the key "book" is linked to a new Book object, which will hold all the information entered in the form.
        // The form data will be bound to this Book object when the form is submitted.
        model.addAttribute("book", new Book());
        return "bookForm"; // returns page: templates/bookForm.html
    }

    @PostMapping("/create_book")
    public String createBook(@ModelAttribute Book book, @RequestParam("coverFile") MultipartFile coverFile) throws Exception {
        // @ModelAttribute binds form input fields to the Book object.
        // @RequestParam binds the uploaded file (coverFile) to a MultipartFile parameter.
        // @RequestParam is used because multipart file uploads cannot be directly bound to the Book object using @ModelAttribute.
        libraryDatabase.saveBook(book, coverFile);
      return "redirect:/books";  // This redirects to the /books endpoint.
    }

    @GetMapping("/books/{id}/cover")
    @ResponseBody
        // It allows Spring to return the method's return value directly in the HTTP response body.
        // Which display the image in the html body.
    public byte[] showCover(@PathVariable Integer id) {
        // This function retrieves the book's cover.
        Book book = libraryDatabase.getById(id);
        return book.getCover();
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        // This function...
        libraryDatabase.deleteBook(id);
        return "redirect:/books";  // This redirects to the /books endpoint.
    }
    
}