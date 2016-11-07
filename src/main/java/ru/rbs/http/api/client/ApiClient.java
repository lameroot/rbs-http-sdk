package ru.rbs.http.api.client;

import ru.rbs.http.api.domain.ApiRequest;

public interface ApiClient {

    HostsProvider getHostsProvider();
    <T> T execute(ApiRequest<T> request) throws Exception;
}
