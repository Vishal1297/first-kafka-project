package org.fretron.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.fretron.kafka.constant.Constant;
import org.fretron.kafka.model.User;
import org.fretron.kafka.serializer.CustomSerializer;

import java.util.Properties;

public class CustomProducer {

    public static KafkaProducer<String, User> createProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constant.KAFKA_BROKERS);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Constant.KAFKA_SERIALIZER);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName());
        return new KafkaProducer<>(properties);
    }
}