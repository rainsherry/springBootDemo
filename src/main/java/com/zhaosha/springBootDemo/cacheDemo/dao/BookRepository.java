package com.zhaosha.springBootDemo.cacheDemo.dao;

import com.zhaosha.springBootDemo.cacheDemo.Book;

/**
 * Created by rainsherry on 2018/5/31.
 */
public interface BookRepository {

    Book getByIsbn(String isbn);
}
