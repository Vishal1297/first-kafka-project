package org.fretron.kafka.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class CustomSerializer : Serializer<Any> {

    override fun serialize(topic: String?, data: Any): ByteArray {
        var retVal: ByteArray? = null
        val objectMapper = ObjectMapper()
        try {
            retVal = objectMapper.writeValueAsString(data).toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return retVal!!
    }

}