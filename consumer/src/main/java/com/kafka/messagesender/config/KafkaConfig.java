package com.kafka.messagesender.config;

import com.kafka.messagesender.contant.KafkaConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * User: munna, Software Engineer
 * Date: 10/6/24
 * Time: 4:42 PM
 * Class Name: KafkaConfig
 */

@Configuration
public class KafkaConfig {
    public NewTopic topic(){
        return TopicBuilder.name(KafkaConstant.KAFKA_TOPIC).build();
    }
}
