package ru.rbs.http.api.client.providers;

import ru.rbs.http.api.client.HostsProvider;

public class WebRbsDevAlfaHostProvider implements HostsProvider {

    private final static String RBS_API_URL = "https://web.rbsdev.com/alfapayment";

    @Override
    public String getRbsApi() {
        return RBS_API_URL;
    }
}
