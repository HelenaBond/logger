package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractAppender implements Appender {

    private DateTimeFormatter dateTimeFormat;
    private String messageFormat;
    private LogLevel from;
    private LogLevel to;

    public AbstractAppender() {
        dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        messageFormat = "[%s] [%s] %s";
        from = LogLevel.INFO;
        to = LogLevel.ERROR;
    }

    @Override
    public DateTimeFormatter getDateTimeFormat() {
        return dateTimeFormat;
    }

    @Override
    public void setDateTimeFormat(DateTimeFormatter dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    @Override
    public String getMessageFormat() {
        return messageFormat;
    }

    @Override
    public void setMessageFormat(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    @Override
    public LogLevel getFrom() {
        return from;
    }

    @Override
    public void setFrom(LogLevel from) {
        this.from = from;
    }

    @Override
    public LogLevel getTo() {
        return to;
    }

    @Override
    public void setTo(LogLevel to) {
        this.to = to;
    }

    @Override
    public String formattingMessage(LogLevel level, String message) {
        String timestamp = LocalDateTime.now().format(dateTimeFormat);
        return String.format(messageFormat, timestamp, level, message);
    }
}
