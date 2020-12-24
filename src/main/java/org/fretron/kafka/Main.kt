package org.fretron.kafka

import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.fretron.kafka.constant.Constant
import org.fretron.kafka.consumer.CustomConsumer
import org.fretron.kafka.model.User
import org.fretron.kafka.producer.CustomProducer
import java.time.Duration
import java.util.*

fun main() {
    Thread {
        runProducer()
    }.start()
    Thread {
        runConsumer()
    }.start()
}

private fun runConsumer() {
    println("Running Consumer...")
    try {
        val consumer: KafkaConsumer<String, User> = CustomConsumer.createConsumer()
        println("Records")
        while (true) {
            val records: ConsumerRecords<String, User> = consumer.poll(Duration.ofMillis(1000))
            for (record in records) {
                println("offset = ${record.offset()}, , key = ${record.key()}, value = ${record.value()}")
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun runProducer() {
    println("Running Producer...")
    val producer: KafkaProducer<String, User>
    try {
        producer = CustomProducer.createProducer()
        producer.send(ProducerRecord(Constant.KAFKA_TOPIC_NAME, UUID.randomUUID().toString(), getFakeUser()))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun getFakeUser(): User {
    return User("myName", 23)
}