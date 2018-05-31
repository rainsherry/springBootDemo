package com.zhaosha.springBootDemo.configDemo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * application.properties属性映射到javabean
 * Created by rainsherry on 2018/5/30.
 */
@ConfigurationProperties(prefix = "rain")
@PropertySource(value = "classpath:configTest.properties")//非 application 配置文件的需要加这个注解指定路径
@Configuration
public class ConfigBean {

    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;

    public String getName() {
        return name;
    }

    public ConfigBean setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public ConfigBean setAge(int age) {
        this.age = age;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public ConfigBean setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public ConfigBean setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public int getMax() {
        return max;
    }

    public ConfigBean setMax(int max) {
        this.max = max;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ConfigBean setValue(String value) {
        this.value = value;
        return this;
    }

    public String getGreeting() {
        return greeting;
    }

    public ConfigBean setGreeting(String greeting) {
        this.greeting = greeting;
        return this;
    }
}
