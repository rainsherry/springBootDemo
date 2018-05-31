package com.zhaosha.springBootDemo.jdbcDemo.service.impl;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;
import com.zhaosha.springBootDemo.jdbcDemo.dao.IAccountDAO;
import com.zhaosha.springBootDemo.jdbcDemo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Service
public class AccountService implements IAccountService {


    @Autowired
    private IAccountDAO accountDAO;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }
}
