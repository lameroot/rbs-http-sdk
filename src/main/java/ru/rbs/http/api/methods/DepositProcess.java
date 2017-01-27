package ru.rbs.http.api.methods;

import ru.rbs.http.api.domain.BaseApiRequest;
import ru.rbs.http.api.domain.DepositParams;
import ru.rbs.http.api.methods.adapters.DepositProcessTypeAdapter;

public class DepositProcess extends BaseProcess {

    public static final class Request extends BaseApiRequest<DepositProcess> {

        @Override
        protected String requestUri() {
            return "/rest/deposit.do";
        }

        public static Request newInstance(DepositParams depositParams) {
            return new Request(depositParams);
        }

        private Request(DepositParams depositParams) {
            super(new DepositProcessTypeAdapter());
            addParameters(depositParams);
        }

        protected void addParameters(DepositParams depositParams) {
            addAuthParameters(depositParams);
            addParameter("orderId", depositParams.getOrderId());
            addParameter("amount", depositParams.getAmount());
        }
    }
}
