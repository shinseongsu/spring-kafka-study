package com.kafka.springkafka.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class KafkaTopicConfiguration {


    @Bean
    public KafkaAdmin.NewTopics clip2s() {
        return new NewTopics(
            TopicBuilder.name("clips2").build(),
            TopicBuilder.name("clips2-bytes").build(),
            TopicBuilder.name("clips2-request").build(),
            TopicBuilder.name("clips2-replies").build()
        );
    }


    // 토픽 생성 관련
//    @Bean
//    public AdminClient adminClient(KafkaAdmin kafkaAdmin) {
//        return AdminClient.create(kafkaAdmin.getConfigurationProperties());
//    }
//
//    @Bean
//    public NewTopic clip2() {
//        return TopicBuilder
//            .name("clip2")
//            .build();
//    }

//    @Bean
//    public KafkaAdmin.NewTopics clips2s() {
//        return new KafkaAdmin.NewTopics(
//            TopicBuilder.name("clip2-part1").build(),
//            TopicBuilder.name("clip2-part2")
//                .partitions(3)
//                .replicas(1)
//                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60 * 60))
//                .build()
//        );
//    }

}
