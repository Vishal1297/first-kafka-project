package org.fretron.kafka.deserializer

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import org.fretron.kafka.model.User


class CustomDeserializer : Deserializer<Any> {

    override fun deserialize(topic: String?, data: ByteArray?): Any {
        val mapper = ObjectMapper()
        var user: User? = null
        try {
            user = mapper.readValue(data, User::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return user as Any
    }

}