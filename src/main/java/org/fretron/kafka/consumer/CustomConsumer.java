package org.fretron.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.fretron.kafka.constant.Constant;
import org.fretron.kafka.deserializer.CustomDeserializer;
import org.fretron.kafka.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomConsumer {

    public static KafkaConsumer<String, User> createConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constant.KAFKA_BROKERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, Constant.KAFKA_GROUP_ID_CONFIG);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        KafkaConsumer<String, User> kafkaConsumer = new KafkaConsumer<>(properties);
        List<String> topics = new ArrayList<>();
        topics.add(Constant.KAFKA_TOPIC_NAME);
        kafkaConsumer.subscribe(topics);
        return kafkaConsumer;
    }
}