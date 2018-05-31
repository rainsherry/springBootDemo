package com.zhaosha.springBootDemo.redisDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * 消息队列：消息接收者
 * Created by rainsherry on 2018/5/31.
 */
public class RedisReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public RedisReceiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiverMessage(String mesasge) {
        LOGGER.info("Receiverd <" + mesasge + ">");
        latch.countDown();
    }


}
