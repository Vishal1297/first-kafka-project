package org.fretron.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.fretron.kafka.constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomConsumer {

    public static KafkaConsumer<String, String> createConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constant.KAFKA_BROKERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, Constant.KAFKA_DESERIALIZER);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Constant.KAFKA_DESERIALIZER);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, Constant.KAFKA_GROUP_ID_CONFIG);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        List<String> topics = new ArrayList<>();
        topics.add(Constant.KAFKA_TOPIC_NAME);
        kafkaConsumer.subscribe(topics);
        return kafkaConsumer;
    }
}