package com.example.springgraphql.service;

import com.example.springgraphql.domain.BookModel;
import com.example.springgraphql.domain.entity.AuthorEntity;
import com.example.springgraphql.domain.entity.BookEntity;
import com.example.springgraphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {

    public BookRepository bookRepository;

    public Long addBook(BookModel.BookInput bookInput) {

        BookEntity bookEntity = bookRepository.save(BookEntity.builder()
                .name(bookInput.name())
                .pageCount(bookInput.pageCount())
                .author(AuthorEntity.builder()
                        .firstName(bookInput.author().firstName())
                        .lastName(bookInput.author().lastName())
                        .build())
                .build());

        return bookEntity.getId();
    }

    public BookEntity getBook(String id) {
        return bookRepository.findById(Long.valueOf(id)).orElse(null);
    }
}
