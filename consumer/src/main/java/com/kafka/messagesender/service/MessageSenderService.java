package com.kafka.messagesender.service;

import com.kafka.messagesender.contant.KafkaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * User: munna, Software Engineer
 * Date: 10/6/24
 * Time: 4:42 PM
 * Class Name: ConsumerService
 * Type: Service class (Contains business logic, acts as an intermediary between controllers and repositories)
 */

@Service
public class MessageSenderService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void produceMessage(String value){
        kafkaTemplate.send(KafkaConstant.KAFKA_TOPIC, value);
    }
}
