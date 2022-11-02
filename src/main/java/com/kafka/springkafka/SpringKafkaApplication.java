package com.kafka.springkafka;

import com.kafka.springkafka.producer.ClipProducer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
    }


    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer) {
        return args -> {
            clipProducer.async("clips2", "Hello, Clip3-async");
            clipProducer.sync("clips2", "Hello, Clip3-sync");
            clipProducer.routingSend("clips2", "Hello, Clip3-routing");
            clipProducer.routingSendBytes("clips2-bytes", "Hello, Clip3-bytes".getBytes(StandardCharsets.UTF_8));
            clipProducer.replyingSend("clips2-request", "Ping Clip3");
        };
    }

    // kakfa 그냥 보내기
//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            kafkaTemplate.send("clips2", "Hello, Clip3");
//        };
//    }

    // step2 . topic 모두 보기
//    @Bean
//    public ApplicationRunner runner(AdminClient adminClient) {
//        return args -> {
//            Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
//            for (String topicName : topics.keySet()) {
//                TopicListing topicListing = topics.get(topicName);
//                System.out.println(topicListing);
//
//                Map<String, TopicDescription> description = adminClient.describeTopics(
//                    Collections.singleton(topicName)).all().get();
//                System.out.println(description);
//
//
//                if(!topicListing.isInternal()) {
//                    adminClient.deleteTopics(Collections.singleton(topicName));
//                }
//            }
//        };
//    }

}
