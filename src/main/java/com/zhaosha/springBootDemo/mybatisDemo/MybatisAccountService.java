package com.zhaosha.springBootDemo.mybatisDemo;

import com.zhaosha.springBootDemo.jdbcDemo.bean.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Service
public class MybatisAccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountTraMapper accountTraMapper;

    int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    int delete(int id) {
        return accountMapper.delete(id);
    }

    Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }


    @Transactional
    public void transfer() throws RuntimeException {
        accountTraMapper.update(90, 1);
        int inter = 100 / 0;//第一条执行完之后，执行此行抛异常，因为加了事物注解，所以diyitiao也不会执行成功
        accountTraMapper.update(110, 2);
    }
}
