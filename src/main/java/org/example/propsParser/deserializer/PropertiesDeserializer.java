package org.example.propsParser.deserializer;

public interface PropertiesDeserializer<T> {
    T deserialize(String value);
}
