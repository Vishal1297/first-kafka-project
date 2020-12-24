package org.fretron.kafka.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.fretron.kafka.constant.Constant
import org.fretron.kafka.model.User
import org.fretron.kafka.serializer.CustomSerializer
import java.util.*

object CustomProducer {
    @JvmStatic
    fun createProducer(): KafkaProducer<String, User> {
        val properties = Properties()
        properties[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = Constant.KAFKA_BROKERS
        properties[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        properties[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = CustomSerializer::class.java
        return KafkaProducer(properties)
    }
}