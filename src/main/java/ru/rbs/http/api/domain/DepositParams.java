package ru.rbs.http.api.domain;

public class DepositParams extends AuthParams {

    private String orderId;
    private Long amount;

    public DepositParams() {
    }

    public DepositParams(String userName, String password, String hostProviderUrl) {
        super(userName, password, hostProviderUrl);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
