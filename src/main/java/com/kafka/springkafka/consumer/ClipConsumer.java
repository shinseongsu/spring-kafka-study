package com.kafka.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clips2-id", topics = "clips2")
    public void listenClip2(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "clips2-bytes-id", topics = "clips2-bytes")
    public void listenClip2Bytes(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "clips2-request-id", topics = "clips2-request")
    @SendTo
    public String listenClip2Request(String message) {
        System.out.println(message);
        return "Pong Clip3";
    }

}
