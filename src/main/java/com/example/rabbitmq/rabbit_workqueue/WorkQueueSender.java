package com.example.rabbitmq.rabbit_workqueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Component
public class WorkQueueSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue workQueue;

    int dots = 0;
    int count = 0;

    public void send(){
        StringBuilder builder = new StringBuilder("Hello");
        if(dots++ == 3){
            dots = 1;
        }

        for (int i = 0;i<dots;i++){
            builder.append(',');
        }

        builder.append(Integer.toString(++count));
        String message = builder.toString();
        rabbitTemplate.convertAndSend(workQueue.getName(),message);
        System.out.println(" [x] Sent '" + message + "'");

    }




}
