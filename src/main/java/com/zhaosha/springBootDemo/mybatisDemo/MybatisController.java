package com.zhaosha.springBootDemo.mybatisDemo;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisAccountService accountService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name") String name,
                                @RequestParam(value = "money") double money) {
        return accountService.update(name, money, id) == 1 ? "success" : "fail";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") int id) {
        return accountService.delete(id) == 1 ? "success" : "fail";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

        return accountService.add(name, money) == 1 ? "success" : "fail";
    }
}
