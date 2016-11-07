package ru.rbs.http.api.domain;

import ru.rbs.http.api.client.HostsProvider;

import java.util.Map;

public interface ApiRequest<T> {

    Method getMethod();
    String requestUrl(HostsProvider hostsProvider);
    Map<String, String> getHeaders();
    Map<String, String> getParameters();
    byte[] getBody();
    String getContentType();
    T parse(HttpClientResponse response) throws Exception;


    enum Method {
        GET,
        POST,
        PUT
    }
}
