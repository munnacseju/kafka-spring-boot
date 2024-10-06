package com.kafka.messagereceiver.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * User: munna, Software Engineer
 * Date: 10/6/24
 * Time: 5:40 PM
 * Class Name: ProducerService
 * Type: Service class (Contains business logic, acts as an intermediary between controllers and repositories)
 */

@Service
public class MessageReceiverService {

    @KafkaListener(topics = "demo-topic", groupId = "producer-group")
    public void consumeTheMessage(String hello){
        System.out.println(hello);
    }
}
