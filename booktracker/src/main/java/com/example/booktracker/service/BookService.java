package com.example.booktracker.service;

import com.example.booktracker.model.Book;
import com.example.booktracker.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public Book update(Long id, Book updatedBook) {
        return repository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setStatus(updatedBook.getStatus());
            book.setRating(updatedBook.getRating());
            book.setNotes(updatedBook.getNotes());
            return repository.save(book);
        }).orElseThrow(() -> new RuntimeException("Libro non trovato"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
    }
}
