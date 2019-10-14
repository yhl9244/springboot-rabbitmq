package com.example.springbootrabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "message")
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String str) {
        logger.info("接收消息："+ str);
        logger.info("接收消息时间："+new Date());
    }
}
