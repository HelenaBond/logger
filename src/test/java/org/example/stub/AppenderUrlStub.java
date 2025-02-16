package org.example.stub;

import org.example.appender.AbstractAppender;
import org.example.propsParser.deserializer.PropsDeserializer;

import java.net.URL;

public class AppenderUrlStub extends AbstractAppender {

    @PropsDeserializer(using = UrlDeserializerStub.class)
    private URL url;

    @Override
    public void append(String message) {
        // stub
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
