package com.zhaosha.springBootDemo.jdbcDemo.dao;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/30.
 */
public interface IAccountDAO {

    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
