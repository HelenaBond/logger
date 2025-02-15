package org.example;

import org.example.Logger;
import org.example.appender.Appender;
import org.example.appender.ConsoleAppender;
import org.example.configurator.AbstractConfigurator;

import java.util.List;

public class LoggerFactory {
    private final AbstractConfigurator loggerConfigurator;

    public LoggerFactory(AbstractConfigurator loggerConfigurator) {
        this.loggerConfigurator = loggerConfigurator;
    }

    public Logger createLogger() {
        Logger logger = loggerConfigurator.configureLogger();
        List<Appender> appenderList = logger.getAppenders();
        if (appenderList.isEmpty()) {
            appenderList.add(new ConsoleAppender());
        }
        return logger;
    }
}
