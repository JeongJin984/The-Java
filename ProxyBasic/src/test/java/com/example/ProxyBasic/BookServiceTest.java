package com.example.ProxyBasic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    BookService bookService = new BookServiceProxy(new DefaultBookService());

    BookService bookServiceDynamic = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {
        BookService bookService = new DefaultBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("asdf");
           Object invoke = method.invoke(bookService, args);
            System.out.println("qwer");
            return invoke;
        }
    });

    @Test
    void di() {
        Book book = new Book("spring");
        bookServiceDynamic.rent(book);
    }

    @Test
    void di2() {
        Book book = new Book("spring");
        bookService.rent(book);
    }
}