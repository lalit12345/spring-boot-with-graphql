package com.example.springgraphql.controller;

import static com.example.springgraphql.domain.BookModel.BookInput;

import com.example.springgraphql.domain.entity.BookEntity;
import com.example.springgraphql.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    public BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @SchemaMapping(typeName = "Mutation")
    @MutationMapping
    public String addBook(@Argument BookInput book) {
        return String.valueOf(bookService.addBook(book));
    }

    @QueryMapping
    public BookEntity getBook(@Argument String id) {
        return bookService.getBook(id);
    }
}
