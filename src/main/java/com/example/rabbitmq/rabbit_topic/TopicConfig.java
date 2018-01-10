package com.example.rabbitmq.rabbit_topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nicholas.chi on 2018/1/10.
 */
@Configuration
public class TopicConfig {

    //创建两个队列
    @Bean(name = "queueMessage")
    public Queue queueMessage(){
        return new Queue("topic.message");
    }

    @Bean(name = "queueMessages")
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }

    //创建交换机
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    //绑定队列
    @Bean
    public Binding binding1(@Qualifier("queueMessage") Queue queueMessage, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding binding2(@Qualifier("queueMessages") Queue queueMessages, TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
