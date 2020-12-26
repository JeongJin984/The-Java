package com.example.SpringDI;

@MyAnnotation
public class Book {
    private String a;

    private static String b = "BOOK";
    private final String c = "COOK";
    public String d = "d";
    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    public void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("G");
    }

    public int h() {
        return 100;
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
