package com.unifecaf.Library_Manager.repository;

import com.unifecaf.Library_Manager.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository <Book, Integer> {}
