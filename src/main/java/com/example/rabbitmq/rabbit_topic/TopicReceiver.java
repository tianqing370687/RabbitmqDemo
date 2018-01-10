package com.example.rabbitmq.rabbit_topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "topic.message")
    public void process(String obj){
        System.out.println("receiver:topic.message:"+obj);
    }

    @RabbitListener(queues = "topic.messages")
    public void process1(String obj){
        System.out.println("receiver:topic.messages:"+obj);
    }

}
