package com.zhaosha.springBootDemo.jpaDemo.controller;

import com.zhaosha.springBootDemo.jpaDemo.bean.JpaAccount;
import com.zhaosha.springBootDemo.jpaDemo.dao.JpaAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private JpaAccountDao jpaAccountDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<JpaAccount> getAccounts() {
        return jpaAccountDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name") String name,
                                @RequestParam(value = "money", required = true) double money) {
        JpaAccount account = new JpaAccount();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        JpaAccount account1 = jpaAccountDao.saveAndFlush(account);

        return account1.toString();

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        JpaAccount account = new JpaAccount();
        account.setMoney(money);
        account.setName(name);
        JpaAccount account1 = jpaAccountDao.save(account);
        return account1.toString();

    }
}
