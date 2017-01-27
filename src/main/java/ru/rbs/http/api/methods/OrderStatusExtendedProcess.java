package ru.rbs.http.api.methods;


import ru.rbs.http.api.domain.*;
import ru.rbs.http.api.methods.adapters.GetOrderStatusExtendedProcessTypeAdapter;

public class OrderStatusExtendedProcess extends BaseProcess {

    private String orderNumber;
    private Integer orderStatus;
    private Integer actionCode;
    private String actionCodeDescription;
    private Long amount;
    private String currency;
    private String date;
    private String orderDescription;
    private String ip;
    private CardAuthInfo cardAuthInfo;
    private SecureAuthInfo secureAuthInfo;
    private BindingInfo bindingInfo;
    private BankInfo bankInfo;
    private PaymentAmountInfo paymentAmountInfo;

    public static final class Request extends BaseApiRequest<OrderStatusExtendedProcess> {

        @Override
        protected String requestUri() {
            return "/rest/getOrderStatusExtended.do";
        }

        public static Request newInstance(OrderStatusExtendedParams orderStatusExtendedParams) {
            return new Request(orderStatusExtendedParams);
        }
        private Request(OrderStatusExtendedParams orderStatusExtendedParams) {
            super(new GetOrderStatusExtendedProcessTypeAdapter());
            addAuthParameters(orderStatusExtendedParams);
            addParameter("orderId",orderStatusExtendedParams.getOrderId());
            addParameter("orderNumber",orderStatusExtendedParams.getOrderNumber());
            addParameter("language",orderStatusExtendedParams.getLanguage());
        }
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getActionCode() {
        return actionCode;
    }

    public void setActionCode(Integer actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCodeDescription() {
        return actionCodeDescription;
    }

    public void setActionCodeDescription(String actionCodeDescription) {
        this.actionCodeDescription = actionCodeDescription;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public CardAuthInfo getCardAuthInfo() {
        return cardAuthInfo;
    }

    public void setCardAuthInfo(CardAuthInfo cardAuthInfo) {
        this.cardAuthInfo = cardAuthInfo;
    }

    public SecureAuthInfo getSecureAuthInfo() {
        return secureAuthInfo;
    }

    public void setSecureAuthInfo(SecureAuthInfo secureAuthInfo) {
        this.secureAuthInfo = secureAuthInfo;
    }

    public BindingInfo getBindingInfo() {
        return bindingInfo;
    }

    public void setBindingInfo(BindingInfo bindingInfo) {
        this.bindingInfo = bindingInfo;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public PaymentAmountInfo getPaymentAmountInfo() {
        return paymentAmountInfo;
    }

    public void setPaymentAmountInfo(PaymentAmountInfo paymentAmountInfo) {
        this.paymentAmountInfo = paymentAmountInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderStatusExtendedProcess{");
        sb.append("orderNumber='").append(orderNumber).append('\'');
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", actionCode=").append(actionCode);
        sb.append(", actionCodeDescription='").append(actionCodeDescription).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", orderDescription='").append(orderDescription).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", cardAuthInfo=").append(cardAuthInfo);
        sb.append(", secureAuthInfo=").append(secureAuthInfo);
        sb.append(", bindingInfo=").append(bindingInfo);
        sb.append(", bankInfo=").append(bankInfo);
        sb.append(", paymentAmountInfo=").append(paymentAmountInfo);
        sb.append('}');
        return sb.toString();
    }
}
