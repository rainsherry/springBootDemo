package com.zhaosha.springBootDemo.cacheDemo;

/**
 * Created by rainsherry on 2018/5/31.
 */
public class Book {

    private String isbn;
    private String title;


    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }
}
