package ru.rbs.http.api.domain;

public class ReverseParams extends AuthParams {

    private String orderId;
    private String language;

    public ReverseParams() {
    }

    public ReverseParams(String userName, String password, String hostProviderUrl) {
        super(userName, password, hostProviderUrl);
    }

    public ReverseParams(EndpointParams endpointParams) {
        super(endpointParams);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
