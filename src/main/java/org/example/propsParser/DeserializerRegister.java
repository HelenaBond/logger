package org.example.propsParser;

import org.example.LogLevel;
import org.example.propsParser.deserializer.PropertiesDeserializer;
import org.example.propsParser.deserializer.typeDeserializer.DateTimeFormatterDeserializer;
import org.example.propsParser.deserializer.typeDeserializer.LogLevelDeserializer;
import org.example.propsParser.deserializer.typeDeserializer.StringDeserializer;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DeserializerRegister {
    private final Map<Class<?>, Class<? extends PropertiesDeserializer<?>>> deserializers = new HashMap<>();
    {
        deserializers.put(DateTimeFormatter.class, DateTimeFormatterDeserializer.class);
        deserializers.put(String.class, StringDeserializer.class);
        deserializers.put(LogLevel.class, LogLevelDeserializer.class);
    }

    public Class<? extends PropertiesDeserializer<?>> getDeserializer(Class<?> clazz) {
        return deserializers.get(clazz);
    }
}
