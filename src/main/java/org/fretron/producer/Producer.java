package org.fretron.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class Producer {

    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(i);
                kafkaProducer.send(new ProducerRecord<>("firstTopic", Integer.toString(i), "test message - " + i ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.flush();
            kafkaProducer.close();
        }
    }
}