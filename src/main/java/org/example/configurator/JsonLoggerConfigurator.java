package org.example.configurator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Logger;

import java.io.File;
import java.io.IOException;

public class JsonLoggerConfigurator extends AbstractConfigurator {

    public JsonLoggerConfigurator(String pathToSettings) {
        super(pathToSettings);
    }

    @Override
    public Logger configureLogger() {
        Logger logger = new Logger();
        ObjectMapper objectMapper = new ObjectMapper();
        File json = new File(getPathToSettings());
        try {
            logger = objectMapper.readValue(json, Logger.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
