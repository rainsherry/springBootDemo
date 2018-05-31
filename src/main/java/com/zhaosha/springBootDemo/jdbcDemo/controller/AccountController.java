package com.zhaosha.springBootDemo.jdbcDemo.controller;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;
import com.zhaosha.springBootDemo.jdbcDemo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccountLists() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name") String name, @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setId(id);
        account.setMoney(money);
        account.setName(name);
        return accountService.update(account) == 1 ? "updateSuccess" : "fail";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name, @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        return accountService.add(account) == 1 ? "addSuccess" : "fail";
    }
}
