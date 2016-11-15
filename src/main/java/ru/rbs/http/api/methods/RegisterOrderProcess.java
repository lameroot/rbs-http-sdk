package ru.rbs.http.api.methods;

import ru.rbs.http.api.client.HostsProvider;
import ru.rbs.http.api.domain.BaseApiRequest;
import ru.rbs.http.api.domain.PageView;
import ru.rbs.http.api.domain.RegisterOrderParams;
import ru.rbs.http.api.methods.adapters.RegisterOrderProcessTypeAdapter;

public class RegisterOrderProcess extends BaseProcess {
    public String orderId;
    public String formUrl;

    public static final class Request extends BaseApiRequest<RegisterOrderProcess> {

        @Override
        protected String requestUrlBase(HostsProvider hostsProvider) {
            return hostsProvider.getRbsApi() + "/rest/register.do";
        }

        public static Request newInstance(RegisterOrderParams registerOrderParams) {
            return new Request(registerOrderParams);
        }

        private Request(RegisterOrderParams registerOrderParams) {
            super(new RegisterOrderProcessTypeAdapter());
            addParameters(registerOrderParams);
        }

        protected void addParameters(RegisterOrderParams registerOrderParams) {
            addParameter("userName", registerOrderParams.getUserName());
            addParameter("password", registerOrderParams.getPassword());
            addParameter("orderNumber",registerOrderParams.getOrderNumber());
            addParameter("amount",registerOrderParams.getAmount());
            addParameter("currency",registerOrderParams.getCurrency());
            addParameter("returnUrl",registerOrderParams.getReturnUrl());
            addParameter("failUrl",registerOrderParams.getFailUrl());
            addParameter("description",registerOrderParams.getDescription());
            addParameter("language",registerOrderParams.getLanguage());
            addParameter("pageView",null != registerOrderParams.getPageView() ? registerOrderParams.getPageView().name() : PageView.DESKTOP.name());
            addParameter("clientId",registerOrderParams.getClientId());
            addParameter("merchantLogin",registerOrderParams.getMerchantLogin());
            addParameter("jsonParams",registerOrderParams.getJsonParams());
            addParameter("sessionTimeoutSecs",registerOrderParams.getSessionTimeoutSecs());
            addParameter("expirationDate",registerOrderParams.getExpirationDate());
            addParameter("bindingId",registerOrderParams.getBindingId());
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterOrderProcess{");
        sb.append("errorCode='").append(getErrorCode()).append('\'');
        sb.append(", errorMessage='").append(getErrorMessage()).append('\'');
        sb.append(", orderId='").append(orderId).append('\'');
        sb.append(", formUrl='").append(formUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
