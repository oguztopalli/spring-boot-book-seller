package com.oguztopalli.springbootbookseller.controller;

import com.oguztopalli.springbootbookseller.model.Book;
import com.oguztopalli.springbootbookseller.model.User;
import com.oguztopalli.springbootbookseller.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping// api/book
    public ResponseEntity<?> saveBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}") //api/book"/{bookId}
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId)
    {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping// api/book
    public ResponseEntity<?> getAllBook()
    {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

}
