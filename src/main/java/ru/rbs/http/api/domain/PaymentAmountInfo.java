package ru.rbs.http.api.domain;

public class PaymentAmountInfo {
    private String approvedAmount;
    private String depositedAmount;
    private String refundedAmount;
    private String paymentState;

    public String getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(String approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(String depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public String getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(String refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }
}
