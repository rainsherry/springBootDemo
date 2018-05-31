package com.zhaosha.springBootDemo;

import com.zhaosha.springBootDemo.redisDemo.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void contextLoads() {
        redisDao.setKey("name", "rainsherry");
        redisDao.getValue("name");
    }

}
