package ru.rbs.http.api.methods;


import ru.rbs.http.api.client.HostsProvider;
import ru.rbs.http.api.domain.*;
import ru.rbs.http.api.methods.adapters.GetOrderStatusExtendedProcessTypeAdapter;

public class OrderStatusExtendedProcess extends BaseProcess {

    public String orderNumber;
    public Integer orderStatus;
    public Integer actionCode;
    public String actionCodeDescription;
    public Long amount;
    public String currency;
    public String date;
    public String orderDescription;
    public String ip;
    public CardAuthInfo cardAuthInfo;
    public SecureAuthInfo secureAuthInfo;
    public BindingInfo bindingInfo;
    public BankInfo bankInfo;
    public PaymentAmountInfo paymentAmountInfo;

    public static final class Request extends BaseApiRequest<OrderStatusExtendedProcess> {
        @Override
        protected String requestUrlBase(HostsProvider hostsProvider) {
            return hostsProvider.getRbsApi() + "/rest/getOrderStatusExtended.do";
        }
        public static Request newInstance(OrderStatusExtendedParams orderStatusExtendedParams) {
            return new Request(orderStatusExtendedParams);
        }
        private Request(OrderStatusExtendedParams orderStatusExtendedParams) {
            super(new GetOrderStatusExtendedProcessTypeAdapter());
            addParameter("userName", orderStatusExtendedParams.getUserName());
            addParameter("password", orderStatusExtendedParams.getPassword());
            addParameter("orderId",orderStatusExtendedParams.getOrderId());
            addParameter("orderNumber",orderStatusExtendedParams.getOrderNumber());
            addParameter("language",orderStatusExtendedParams.getLanguage());
        }
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
