package com.zhaosha.springBootDemo.jdbcDemo.service;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

}
