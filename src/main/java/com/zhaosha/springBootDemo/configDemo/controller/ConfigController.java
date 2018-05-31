package com.zhaosha.springBootDemo.configDemo.controller;

import com.zhaosha.springBootDemo.configDemo.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rainsherry on 2018/5/30.
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class ConfigController {

    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/config")
    public String config() {
        return configBean.getName() + "," +
                configBean.getAge() + "," +
                configBean.getNumber() + "," +
                configBean.getUuid() + "," +
                configBean.getMax() + "," +
                configBean.getValue() + "," +
                configBean.getGreeting();
    }
}
