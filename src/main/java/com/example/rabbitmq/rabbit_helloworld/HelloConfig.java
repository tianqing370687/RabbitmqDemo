package com.example.rabbitmq.rabbit_helloworld;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Configuration
public class HelloConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
