package ru.rbs.http.api.client.providers;

import ru.rbs.http.api.client.HostsProvider;

public class CustomHostProvider implements HostsProvider {

    private final String rbsApiUrl;

    public CustomHostProvider(String rbsApiUrl) {
        this.rbsApiUrl = rbsApiUrl;
    }

    @Override
    public String getRbsApi() {
        return rbsApiUrl;
    }
}
