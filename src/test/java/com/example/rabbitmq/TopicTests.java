package com.example.rabbitmq;

import com.example.rabbitmq.rabbit_topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTests {

	@Autowired
    TopicSender sender;

	@Test
	public void contextLoads() {
		int i = 0;
		while (i<20){
			sender.send();
			i++;
		}
	}

}
