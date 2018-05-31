package com.zhaosha.springBootDemo.demoController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rainsherry on 2018/5/30.
 */
@RestController
public class DemoController {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @RequestMapping("/index")
    public String index() {
        return "hello,spring boot!";
    }

    @RequestMapping("/getMyInfoConfig")
    public String getMyInfoConfig() {
        return name + "," + age + "岁";
    }
}
