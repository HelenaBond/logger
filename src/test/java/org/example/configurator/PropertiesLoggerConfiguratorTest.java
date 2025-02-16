package org.example.configurator;

import org.example.LogLevel;
import org.example.Logger;
import org.example.LoggerFactory;
import org.example.appender.AppenderRegister;
import org.example.appender.FileAppender;
import org.example.stub.AppenderUrlStub;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PropertiesLoggerConfiguratorTest {

    @Test
    public void whenFoolFileAppenderByPropertiesConfigureSuccessfully() {
        AbstractConfigurator loggerConfigurator = new PropertiesLoggerConfigurator(
                "src/test/resources/foolLoggerTest.properties");
        LoggerFactory loggerFactory = new LoggerFactory(loggerConfigurator);
        Logger logger = loggerFactory.createLogger();
        FileAppender fileAppender = (FileAppender) logger.getAppenders().getFirst();
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        DateTimeFormatter actualFormatter = fileAppender.getDateTimeFormat();
        assertThat(actualFormatter.format(LocalDateTime.now()))
                .isEqualTo(expectedFormatter.format(LocalDateTime.now()));
        assertThat(fileAppender.getMessageFormat()).isEqualTo("%s %s %s");
        assertThat(fileAppender.getFrom()).isEqualTo(LogLevel.DEBUG);
        assertThat(fileAppender.getTo()).isEqualTo(LogLevel.WARN);
        assertThat(fileAppender.getFilePath()).isEqualTo("appenderTest.txt");
    }

    @Test
    public void whenDefaultFileAppenderByPropertiesConfigureSuccessfully() {
        AbstractConfigurator loggerConfigurator = new PropertiesLoggerConfigurator(
                "src/test/resources/defaultLoggerTest.properties");
        LoggerFactory loggerFactory = new LoggerFactory(loggerConfigurator);
        Logger logger = loggerFactory.createLogger();
        FileAppender fileAppender = (FileAppender) logger.getAppenders().getFirst();
        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter actualFormatter = fileAppender.getDateTimeFormat();
        assertThat(actualFormatter.format(LocalDateTime.now()))
                .isEqualTo(expectedFormatter.format(LocalDateTime.now()));
        assertThat(fileAppender.getMessageFormat()).isEqualTo("[%s] [%s] %s");
        assertThat(fileAppender.getFrom()).isEqualTo(LogLevel.INFO);
        assertThat(fileAppender.getTo()).isEqualTo(LogLevel.ERROR);
        assertThat(fileAppender.getFilePath()).isEqualTo("log.txt");
    }

    @Test
    public void whenAddCustomAppenderUrlStubWithCustomPropertiesDeserializers() throws MalformedURLException {
        AppenderRegister appenderRegister = new AppenderRegister();
        appenderRegister.registerAppender("stubUrl", AppenderUrlStub.class);
        AbstractConfigurator loggerConfigurator = new PropertiesLoggerConfigurator(
                appenderRegister,
                "src/test/resources/customAppenderTest.properties");
        LoggerFactory loggerFactory = new LoggerFactory(loggerConfigurator);
        Logger logger = loggerFactory.createLogger();
        AppenderUrlStub stub = (AppenderUrlStub) logger.getAppenders().getFirst();
        assertThat(stub.getUrl()).isEqualTo(new URL(("http://localhost:8080")));
        assertThat(stub.getFrom()).isEqualTo(LogLevel.INFO);
    }
}
