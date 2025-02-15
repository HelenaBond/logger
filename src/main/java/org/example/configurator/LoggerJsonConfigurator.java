package org.example.configurator;

import org.example.Logger;

public class LoggerJsonConfigurator implements LoggerConfigurator {

    private final String pathToSettings;

    public LoggerJsonConfigurator(String pathToSettings) {
        this.pathToSettings = pathToSettings;
    }

    @Override
    public Logger configureLogger() {
        return null;
    }
}
