package org.example.propsParser.deserializer.typeDeserializer;

import org.example.propsParser.deserializer.PropertiesDeserializer;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDeserializer implements PropertiesDeserializer<DateTimeFormatter> {
    @Override
    public DateTimeFormatter deserialize(String value) {
        return DateTimeFormatter.ofPattern(value);
    }
}