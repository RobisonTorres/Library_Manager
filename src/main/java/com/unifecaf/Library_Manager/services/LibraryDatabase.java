package com.unifecaf.Library_Manager.services;

import com.unifecaf.Library_Manager.models.Book;
import com.unifecaf.Library_Manager.repository.BooksRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryDatabase {

    private final BooksRepository booksRepository;

    public LibraryDatabase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Iterable<Book> getAllBooks() {

        return booksRepository.findAll();
    }

    public Book saveBook(Book book) {

        return booksRepository.save(book);
    }
}