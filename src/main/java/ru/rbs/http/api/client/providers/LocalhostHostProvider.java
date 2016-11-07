package ru.rbs.http.api.client.providers;

import ru.rbs.http.api.client.HostsProvider;

public class LocalhostHostProvider implements HostsProvider {

    private final String rbsApiUrl;

    public LocalhostHostProvider(String rbsApiUrl) {
        this.rbsApiUrl = rbsApiUrl;
    }

    @Override
    public String getRbsApi() {
        return rbsApiUrl;
    }
}
