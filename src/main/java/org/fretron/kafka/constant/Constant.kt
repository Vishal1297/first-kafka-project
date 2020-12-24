package org.fretron.kafka.constant

object Constant {
    // Kafka Constants
    const val KAFKA_BROKERS = "localhost:9092"
    const val KAFKA_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer"
    const val KAFKA_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer"
    const val KAFKA_GROUP_ID_CONFIG = "user-group"
    const val KAFKA_TOPIC_NAME = "user"
}