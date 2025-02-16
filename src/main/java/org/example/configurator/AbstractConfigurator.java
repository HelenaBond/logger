package org.example.configurator;

import org.example.appender.AppenderRegister;

public abstract class AbstractConfigurator implements LoggerConfigurator {

    private final String pathToSettings;
    private final AppenderRegister appenderRegister;

    public AbstractConfigurator(String pathToSettings) {
        this.pathToSettings = pathToSettings;
        appenderRegister = new AppenderRegister();
    }

    public AbstractConfigurator(AppenderRegister appenderRegister, String pathToSettings) {
        this.pathToSettings = pathToSettings;
        this.appenderRegister = appenderRegister;
    }

    public String getPathToSettings() {
        return pathToSettings;
    }

    public AppenderRegister getAppenderRegister() {
        return appenderRegister;
    }
}
