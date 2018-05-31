package com.zhaosha.springBootDemo.jpaDemo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Entity//@Entity表明是一个映射的实体类
public class JpaAccount {

    @Id//表明id
    @GeneratedValue//字段自动生成
    private int id;
    private String name;
    private double money;

    public JpaAccount() {
    }

    public int getId() {
        return id;
    }

    public JpaAccount setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JpaAccount setName(String name) {
        this.name = name;
        return this;
    }

    public double getMoney() {
        return money;
    }

    public JpaAccount setMoney(double money) {
        this.money = money;
        return this;
    }
}
