package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(String bookName) {
        System.out.println("BookService: Adding book - " + bookName);
        bookRepository.saveBook(bookName);
    }
}
