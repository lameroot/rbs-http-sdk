package ru.rbs.http.api.domain;

import java.io.IOException;
import java.io.InputStream;

public interface HttpClientResponse {

    int getCode();
    String getMessage();
    String getUrl();
    String getHeader(String name);
    String getBody() throws IOException;
    InputStream getByteStream();
}
