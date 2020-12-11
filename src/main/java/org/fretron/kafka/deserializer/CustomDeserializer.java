package org.fretron.kafka.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.fretron.kafka.model.User;

import java.util.Map;

public class CustomDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map configs, boolean isKey) {
        // TODO: 11/12/20
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(data, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void close() {
        // TODO: 11/12/20
    }
}
