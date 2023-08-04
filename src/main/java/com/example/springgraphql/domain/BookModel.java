package com.example.springgraphql.domain;

public class BookModel {

    public static record BookInput(String id, String name, Author author, Integer pageCount) {}

    public static record Author(String id, String firstName, String lastName) {}
}
