package com.zhaosha.springBootDemo.cacheDemo.dao.impl;

import com.zhaosha.springBootDemo.cacheDemo.Book;
import com.zhaosha.springBootDemo.cacheDemo.dao.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")//开启缓存策略，当缓存有这个数据的时候，会直接返回数据，不会等待去查询数据库
    public Book getByIsbn(String isbn) {
        try {
            long time = 3000l;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return new Book(isbn, "Some book");
    }
}
