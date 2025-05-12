package com.unifecaf.Library_Manager.services;

import com.unifecaf.Library_Manager.models.Book;
import com.unifecaf.Library_Manager.repository.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LibraryDatabase {

    private final BooksRepository booksRepository;

    public LibraryDatabase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book getById(Integer id) {
        // This function retrieves a book by ID.
        return booksRepository.findById(id).orElse(null);
    }

    public Iterable<Book> getAllBooks() {
        // This function retrieves all books stored in the database.
        return booksRepository.findAll();
    }

    public Book saveBook(Book book, MultipartFile coverFile) throws Exception {
        // This function saves a new book in the database.
        if (coverFile != null && !coverFile.isEmpty()) {
            book.setCover(coverFile.getBytes());
        }
        return booksRepository.save(book);
    }

    public void deleteBook(Integer id) {
        // This function deletes a book by id.
        booksRepository.deleteById(id);
    }

    public Iterable<Book> searchByTitle(String title) {
        // This function finds a book by title.
        return booksRepository.findBookByTitle(title);
    }

    public Iterable<Book> searchByAuthor(String author) {
        // This function finds a book by author.
        return booksRepository.findBookByAuthor(author);
    }

    public Iterable<Book> searchByPublisher(String publisher) {
        // This function finds a book by publisher.
        return booksRepository.findBookByPublisher(publisher);
    }
}