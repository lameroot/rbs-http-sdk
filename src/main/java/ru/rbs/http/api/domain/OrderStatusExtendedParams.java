package ru.rbs.http.api.domain;

public class OrderStatusExtendedParams extends AuthParams {

    private String orderId;
    private String orderNumber;
    private String language;

    public OrderStatusExtendedParams() {
    }

    public OrderStatusExtendedParams(String userName, String password, String hostProviderUrl) {
        super(userName, password, hostProviderUrl);
    }

    public OrderStatusExtendedParams(EndpointParams endpointParams) {
        super(endpointParams);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
