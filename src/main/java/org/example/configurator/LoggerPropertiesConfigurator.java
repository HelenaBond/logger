package org.example.configurator;

import org.example.Logger;
import org.example.propsParser.DeserializerRegister;

public class LoggerPropertiesConfigurator extends AbstractConfigurator {

    private static final String PREFIX = "log.appender.";
    private static final String NAMES = "log.appenders";
    private final String pathToSettings;
    private final DeserializerRegister deserializerRegister = new DeserializerRegister();

    public LoggerPropertiesConfigurator(String pathToSettings) {
        this.pathToSettings = pathToSettings;
    }

    @Override
    public Logger configureLogger() {
        return null;
    }
}
