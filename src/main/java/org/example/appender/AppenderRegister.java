package org.example.appender;

import java.util.HashMap;
import java.util.Map;

public class AppenderRegister {
    private final Map<String, Class<? extends Appender>> appenderTypes = new HashMap<>();
    {
        appenderTypes.put("file", FileAppender.class);
        appenderTypes.put("console", ConsoleAppender.class);
    }

    public void registerAppender(String appenderName, Class<? extends Appender> appender) {
        if (appenderTypes.containsKey(appenderName)) {
            throw new IllegalArgumentException("Appender appenderName already registered: " + appenderName);
        }
        appenderTypes.put(appenderName, appender);
    }

    public Class<? extends Appender> getAppenderType(String type) {
        return appenderTypes.get(type);
    }
}
