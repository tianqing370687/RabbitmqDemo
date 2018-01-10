package com.example.rabbitmq.rabbit_helloworld;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Component
public class HelloReceiver {

    @RabbitListener(queues = "hello")
    public void process(String hello){
        System.out.println("Receiver : " + hello);
    }

}
