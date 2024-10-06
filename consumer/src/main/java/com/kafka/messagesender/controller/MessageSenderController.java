package com.kafka.messagesender.controller;

import com.kafka.messagesender.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: munna, Software Engineer
 * Date: 10/6/24
 * Time: 4:37 PM
 * Class Name: ConsumerController
 * Type: Controller class (Handles incoming HTTP requests, interacts with services, and returns HTTP responses).
 */

@RestController
@RequestMapping("/testing")
public class MessageSenderController {

    @Autowired
    private MessageSenderService consumerService;

    @PutMapping("/hello")
    public ResponseEntity hello() throws InterruptedException {

        for(int i=0; i<100; i++){
            consumerService.produceMessage("Hello + " + i);
            Thread.sleep(1000);
        }

        return new ResponseEntity<> ("Hello", HttpStatus.OK);
    }

}
