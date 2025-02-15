package org.example.configurator;

import org.example.appender.AppenderRegister;

public abstract class AbstractConfigurator implements LoggerConfigurator {
    private final AppenderRegister appenderRegister = new AppenderRegister();

}
