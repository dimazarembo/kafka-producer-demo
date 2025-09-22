package com.example.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Autowired
    Environment environment;

    @Bean
    public ProducerFactory<String, Order> producerFactory(ObjectMapper objectMapper) {
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                environment.getProperty("spring.kafka.producer.bootstrap-servers"));
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                environment.getProperty("spring.kafka.producer.key-serializer"));
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                environment.getProperty("spring.kafka.producer.value-serializer"));
        configProperties.put(ProducerConfig.ACKS_CONFIG,
                environment.getProperty("spring.kafka.producer.acks"));
        return new DefaultKafkaProducerFactory<>(configProperties);
    }

    @Bean
    public KafkaTemplate<String, Order> kafkaTemplate(ProducerFactory<String, Order> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
