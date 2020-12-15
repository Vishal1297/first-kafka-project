package org.fretron.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.fretron.kafka.constant.Constant;
import org.fretron.kafka.consumer.CustomConsumer;
import org.fretron.kafka.producer.CustomProducer;

public class Main {

    public static void main(String[] args) {
        new Thread(Main::runProducer).start();
        new Thread(Main::runConsumer).start();
    }

    private static void runConsumer() {
        System.out.println("Running Consumer...");
        try (Consumer<String, String> consumer = CustomConsumer.createConsumer()) {
            do {
                ConsumerRecords<String, String> records = consumer.poll(10);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProducer() {
        System.out.println("Running Producer...");
        Producer<String, String> producer = CustomProducer.createProducer();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                producer.send(new ProducerRecord<>(Constant.KAFKA_TOPIC_NAME, Integer.toString(i), "test message - " + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.flush();
            producer.close();
        }
    }
}