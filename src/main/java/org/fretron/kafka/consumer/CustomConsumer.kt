package org.fretron.kafka.consumer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.fretron.kafka.constant.Constant
import org.fretron.kafka.deserializer.CustomDeserializer
import org.fretron.kafka.model.User
import java.util.*

object CustomConsumer {

    @JvmStatic
    fun createConsumer(): KafkaConsumer<String, User> {
        val properties = Properties()
        properties[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = Constant.KAFKA_BROKERS
        properties[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        properties[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = CustomDeserializer::class.java
        properties[ConsumerConfig.GROUP_ID_CONFIG] = Constant.KAFKA_GROUP_ID_CONFIG
        properties[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = false
        val kafkaConsumer = KafkaConsumer<String, User>(properties)
        val topics: MutableList<String> = ArrayList()
        topics.add(Constant.KAFKA_TOPIC_NAME)
        kafkaConsumer.subscribe(topics)
        return kafkaConsumer
    }

}