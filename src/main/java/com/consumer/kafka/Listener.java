package com.consumer.kafka;

import com.consumer.Constant;
import com.consumer.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class Listener {

    Logger logger = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(topics = Constant.USER_CREATED, groupId = "group-1")
    public void sendNotification(ConsumerRecord<String, User> record){
        User user = record.value();
        logger.info("------------------------In consumer-----------------------------");
        logger.info(user.toString());
        System.out.println("Received User: " + user);
        logger.info("------------------------In consumer-----------------------------");

    }
}
