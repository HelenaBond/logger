package org.example.appender;

public interface Appender extends Formattable {
    void append(String message);
}
