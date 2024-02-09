package com.apilib.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apilib.domain.book.Book;
import com.apilib.domain.book.BookRepository;
import com.apilib.domain.book.RequestBook;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookRepository repository;

    @GetMapping
    public ResponseEntity<Object> getAllBooks() {
        var allBooks = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allBooks);
    }

    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody @Valid RequestBook data) {
        Book newBook = new Book(data);
        repository.save(newBook);
        return ResponseEntity.ok("Criado com sucesso!");
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> updateBook(@RequestBody @Valid RequestBook data) {
        Optional<Book> optionalBook = repository.findById(data.id());
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setName(data.name());
            book.setDescription(data.description());
            book.setImage(data.image());

            return ResponseEntity.ok(book);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteBook(@PathVariable Integer id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
