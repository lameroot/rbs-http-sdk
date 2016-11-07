package ru.rbs.http.api.methods;

import ru.rbs.http.api.client.HostsProvider;
import ru.rbs.http.api.domain.BaseApiRequest;
import ru.rbs.http.api.domain.PaymentOrderParams;
import ru.rbs.http.api.domain.ReturnUrlObject;
import ru.rbs.http.api.methods.adapters.PaymentOrderProcessProcessTypeAdapter;

public class PaymentOrderProcess extends BaseProcess {

    public ReturnUrlObject returnUrlObject;
    public String info;

    public boolean isSslPayment() {
        return returnUrlObject.getParams().containsKey("termUrl");
    }

    public static final class Request extends BaseApiRequest<PaymentOrderProcess> {
        @Override
        protected String requestUrlBase(HostsProvider hostsProvider) {
            return hostsProvider.getRbsApi() + "/rest/processform.do";
        }

        @Override
        public Method getMethod() {
            return Method.POST;
        }

        public static Request newInstance(PaymentOrderParams paymentOrderParams) {
            return new Request(paymentOrderParams);
        }
        private Request(PaymentOrderParams paymentOrderParams) {
            super(new PaymentOrderProcessProcessTypeAdapter());
            addParameter("userName", paymentOrderParams.getUserName());
            addParameter("password", paymentOrderParams.getPassword());
            addParameter("language", paymentOrderParams.getLanguage());
            addParameter("MDORDER", paymentOrderParams.getMdOrder());
            addParameter("paymentWay",paymentOrderParams.getPaymentWay());
            addParameter("jsonParams",paymentOrderParams.getParams());
            addParameter("$PAN",paymentOrderParams.getPan());
            addParameter("$CVC",paymentOrderParams.getCvc());
            addParameter("YYYY",paymentOrderParams.getExpiry().substring(0,4));
            addParameter("MM",paymentOrderParams.getExpiry().substring(4));
            addParameter("TEXT",paymentOrderParams.getCardHolder());
            addParameter("login",paymentOrderParams.getLogin());
            addParameter("ip",paymentOrderParams.getIp());
            addParameter("eci",paymentOrderParams.getEci());
            addParameter("cavv",paymentOrderParams.getCavv());
            addParameter("xid",paymentOrderParams.getXid());
            addParameter("email",paymentOrderParams.getEmail());
            addParameter("bindingNotNeeded",paymentOrderParams.getBindingId());
            addParameter("bindingId",paymentOrderParams.getBindingId());
            addParameter("pointsAmount",paymentOrderParams.getPointsAmount());
            addParameter("loyaltyId",paymentOrderParams.getLoyaltyId());
        }
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("PaymentOrderProcess{");
//        sb.append("redirect='").append(redirect).append('\'');
//        sb.append(", info='").append(info).append('\'');
//        sb.append(", error='").append(error).append('\'');
//        sb.append(", acsUrl='").append(acsUrl).append('\'');
//        sb.append(", paReq='").append(paReq).append('\'');
//        sb.append(", termUrl='").append(termUrl).append('\'');
//        sb.append(", pnr='").append(pnr).append('\'');
//        sb.append('}');
//        return sb.toString();
//    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentOrderProcess{");
        sb.append("returnUrlObject=").append(returnUrlObject);
        sb.append(", info='").append(info).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
