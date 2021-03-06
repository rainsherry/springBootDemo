package com.zhaosha.springBootDemo.mongodbDemo.bean;

import org.springframework.data.annotation.Id;

/**
 * Created by rainsherry on 2018/5/31.
 */
public class Customer {

    @Id
    public String id;
    public String firstName;
    public String lastName;


    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s,firstName='%s',lastname='%s']",
                id, firstName, lastName);
    }
}
