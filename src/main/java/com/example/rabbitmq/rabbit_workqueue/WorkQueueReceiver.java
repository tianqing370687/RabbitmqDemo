package com.example.rabbitmq.rabbit_workqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Component
public class WorkQueueReceiver {

    @RabbitListener(queues = "workQueue")
    public void receive(String in) throws InterruptedException{
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance  [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance  [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
