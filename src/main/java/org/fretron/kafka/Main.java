package org.fretron.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.fretron.kafka.constant.Constant;
import org.fretron.kafka.consumer.CustomConsumer;
import org.fretron.kafka.model.User;
import org.fretron.kafka.producer.CustomProducer;

public class Main {

    public static void main(String[] args) {
        new Thread(Main::runProducer).start();
        new Thread(Main::runConsumer).start();
    }

    private static void runConsumer() {
        System.out.println("Running Consumer...");
        try (KafkaConsumer<String, User> consumer = CustomConsumer.createConsumer()) {
            System.out.println("Records");
            while (true) {
                ConsumerRecords<String, User> records = consumer.poll(10);
                for (ConsumerRecord<String, User> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProducer() {
        System.out.println("Running Producer...");
        try (KafkaProducer<String, User> producer = CustomProducer.createProducer()) {
            producer.send(new ProducerRecord<>(Constant.KAFKA_TOPIC_NAME, getFakeUser()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getFakeUser() {
        return new User("Vishal", 23);
    }
}