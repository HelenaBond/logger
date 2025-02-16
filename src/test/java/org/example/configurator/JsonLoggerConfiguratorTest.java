package org.example.configurator;

import org.example.LogLevel;
import org.example.Logger;
import org.example.LoggerFactory;
import org.example.appender.ConsoleAppender;
import org.example.appender.FileAppender;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JsonLoggerConfiguratorTest {

    @Test
    public void  whenFoolFileAppenderByJsonConfigureSuccessfully() {
        AbstractConfigurator configurator = new JsonLoggerConfigurator(
                "src/test/resources/foolLoggerTestJson.json");
        LoggerFactory factory = new LoggerFactory(configurator);
        Logger logger = factory.createLogger();
        FileAppender fileAppender = (FileAppender) logger.getAppenders().getFirst();
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        DateTimeFormatter actualFormatter = fileAppender.getDateTimeFormat();
        assertThat(actualFormatter.format(LocalDateTime.now()))
                .isEqualTo(expectedFormatter.format(LocalDateTime.now()));
        assertThat(fileAppender.getMessageFormat()).isEqualTo("%s %s %s");
        assertThat(fileAppender.getFrom()).isEqualTo(LogLevel.DEBUG);
        assertThat(fileAppender.getTo()).isEqualTo(LogLevel.WARN);
        assertThat(fileAppender.getFilePath()).isEqualTo("log.txt");
        ConsoleAppender consoleAppender = (ConsoleAppender) logger.getAppenders().get(1);
        assertThat(consoleAppender.getTo()).isEqualTo(LogLevel.ERROR);
    }
}