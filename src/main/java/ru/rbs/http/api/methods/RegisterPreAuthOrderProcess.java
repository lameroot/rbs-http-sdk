package ru.rbs.http.api.methods;

import ru.rbs.http.api.domain.BaseApiRequest;
import ru.rbs.http.api.domain.RegisterOrderParams;
import ru.rbs.http.api.methods.adapters.RegisterPreAuthOrderProcessTypeAdapter;

public class RegisterPreAuthOrderProcess extends RegisterOrderProcess {

    public static final class Request extends BaseApiRequest<RegisterPreAuthOrderProcess> {

        @Override
        protected String requestUri() {
            return "/rest/registerPreAuth.do";
        }

        public static Request newInstance(RegisterOrderParams registerOrderParams) {
            return new Request(registerOrderParams);
        }

        private Request(RegisterOrderParams registerOrderParams) {
            super(new RegisterPreAuthOrderProcessTypeAdapter());
            addParameters(registerOrderParams);
        }

        protected void addParameters(RegisterOrderParams registerOrderParams) {
            addAuthParameters(registerOrderParams);
            addParameter("orderNumber",registerOrderParams.getOrderNumber());
            addParameter("amount",registerOrderParams.getAmount());
            addParameter("currency",registerOrderParams.getCurrency());
            addParameter("returnUrl",registerOrderParams.getReturnUrl());
            addParameter("failUrl",registerOrderParams.getFailUrl());
            addParameter("description",registerOrderParams.getDescription());
            addParameter("language",registerOrderParams.getLanguage());
            addParameter("pageView",registerOrderParams.getPageView().name());
            addParameter("clientId",registerOrderParams.getClientId());
            addParameter("merchantLogin",registerOrderParams.getMerchantLogin());
            addParameter("jsonParams",registerOrderParams.getJsonParams().toString());
            addParameter("sessionTimeoutSecs",registerOrderParams.getSessionTimeoutSecs());
            addParameter("expirationDate",registerOrderParams.getExpirationDate());
            addParameter("bindingId",registerOrderParams.getBindingId());
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterPreAuthOrderProcess{");
        sb.append("errorCode='").append(getErrorCode()).append('\'');
        sb.append(", errorMessage='").append(getErrorMessage()).append('\'');
        sb.append(", orderId='").append(getOrderId()).append('\'');
        sb.append(", formUrl='").append(getFormUrl()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
