package com.zhaosha.springBootDemo.jdbcDemo.bean;

/**
 * Created by rainsherry on 2018/5/30.
 */
public class Account {

    private Integer id;
    private String name;
    private double money;

    public Integer getId() {
        return id;
    }

    public Account setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public double getMoney() {
        return money;
    }

    public Account setMoney(double money) {
        this.money = money;
        return this;
    }
}
