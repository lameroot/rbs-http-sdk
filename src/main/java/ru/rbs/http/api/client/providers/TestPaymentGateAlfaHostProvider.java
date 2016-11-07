package ru.rbs.http.api.client.providers;

import ru.rbs.http.api.client.HostsProvider;

public class TestPaymentGateAlfaHostProvider implements HostsProvider {

    private final static String RBS_API_URL = "https://test.paymentgate.ru/testpayment";

    @Override
    public String getRbsApi() {
        return RBS_API_URL;
    }
}
