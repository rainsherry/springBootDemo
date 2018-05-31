package com.zhaosha.springBootDemo.AsyncDemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 接收数据的实体
 *
 * @JsonIgnoreProperties(ignoreUnknown = true)，将这个注解写在类上之后，就会忽略类中不存在的字段
 * @JsonIgnore注解用来忽略某些字段
 * @JsonIgnoreProperties({ "internalId", "secretKey" })指定的字段不会被序列化和反序列化
 * Created by rainsherry on 2018/5/31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String name;
    private String blog;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getBlog() {
        return blog;
    }

    public User setBlog(String blog) {
        this.blog = blog;
        return this;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
