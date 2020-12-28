package com.example.ProxyBasic;

public class BookServiceProxy implements BookService {
    DefaultBookService defaultBookService;

    public BookServiceProxy(DefaultBookService bookService) {
        defaultBookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("aaaa");
        defaultBookService.rent(book);
        System.out.println("bbbb");
    }
}
