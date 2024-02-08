package com.apilib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apilib.domain.book.BookRepository;
import com.apilib.domain.book.RequestBook;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookRepository repository;

    @GetMapping
    public ResponseEntity getAllBooks() {
        var allBooks = repository.findAll();
        return ResponseEntity.ok(allBooks);
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody @Valid RequestBook data) {
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

}
