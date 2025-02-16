package org.example.propsParser.deserializer.typeDeserializer;

import org.example.propsParser.deserializer.PropertiesDeserializer;

public class StringDeserializer implements PropertiesDeserializer<String> {
    @Override
    public String deserialize(String value) {
        return value;
    }
}