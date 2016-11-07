package ru.rbs.http.api.client;

import okhttp3.Response;
import ru.rbs.http.api.domain.HttpClientResponse;

import java.io.IOException;
import java.io.InputStream;

import static ru.rbs.http.api.util.Common.checkNotNull;

final class OkHttpClientResponse implements HttpClientResponse {

    private final Response response;
    private final boolean debug;

    OkHttpClientResponse(Response response, boolean debug) {
        this.response = checkNotNull(response, "response");
        this.debug = debug;
    }

    @Override
    public int getCode() {
        return response.code();
    }

    @Override
    public String getMessage() {
        return response.message();
    }

    @Override
    public String getUrl() {
        return response.request().url().toString();
    }

    @Override
    public String getHeader(String name) {
        return response.header(name);
    }

    @Override
    public String getBody() throws IOException {
        return response.body().string();
    }

    @Override
    public InputStream getByteStream() {
        InputStream stream = response.body().byteStream();
        return debug ? new ResponseLoggingInputStream(stream) : stream;
    }
}
