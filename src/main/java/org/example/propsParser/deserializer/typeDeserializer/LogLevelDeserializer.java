package org.example.propsParser.deserializer.typeDeserializer;

import org.example.LogLevel;
import org.example.propsParser.deserializer.PropertiesDeserializer;

public class LogLevelDeserializer implements PropertiesDeserializer<LogLevel> {
    @Override
    public LogLevel deserialize(String value) {
        return LogLevel.valueOf(value);
    }
}