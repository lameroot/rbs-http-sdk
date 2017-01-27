package ru.rbs.http.api.methods;

import ru.rbs.http.api.domain.BaseApiRequest;
import ru.rbs.http.api.domain.PaymentOrderBindingParams;
import ru.rbs.http.api.methods.adapters.PaymentOrderBindingProcessTypeAdapter;

public class PaymentOrderBindingProcess extends PaymentOrderProcess {

    public static final class Request extends BaseApiRequest<PaymentOrderBindingProcess> {

        @Override
        protected String requestUri() {
            return "/rest/paymentOrderBinding.do";
        }

        @Override
        public Method getMethod() {
            return Method.POST;
        }

        public static Request newInstance(PaymentOrderBindingParams paymentOrderBindingParams) {
            return new Request(paymentOrderBindingParams);
        }

        private Request(PaymentOrderBindingParams paymentOrderBindingParams) {
            super(new PaymentOrderBindingProcessTypeAdapter());
            addAuthParameters(paymentOrderBindingParams);
            addParameter("mdOrder", paymentOrderBindingParams.getMdOrder());
            addParameter("bindingId", paymentOrderBindingParams.getBindingId());
            addParameter("language", paymentOrderBindingParams.getLanguage());
            addParameter("ip", paymentOrderBindingParams.getIp());
            addParameter("cvc", paymentOrderBindingParams.getCvc());
            addParameter("email", paymentOrderBindingParams.getEmail());
        }
    }

}
