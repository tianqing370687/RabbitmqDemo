package com.example.rabbitmq.rabbit_topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        rabbitTemplate.convertAndSend("exchange","topic.message",simpleDateFormat.format(new Date())+"主题转发模式");
        rabbitTemplate.convertAndSend("exchange","topic.test",simpleDateFormat.format(new Date())+"主题转发模式");
    }


}
