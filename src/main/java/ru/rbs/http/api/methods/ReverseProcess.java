package ru.rbs.http.api.methods;

import ru.rbs.http.api.domain.BaseApiRequest;
import ru.rbs.http.api.domain.ReverseParams;
import ru.rbs.http.api.methods.adapters.ReverseProcessTypeAdapter;

public class ReverseProcess extends BaseProcess {

    public static final class Request extends BaseApiRequest<ReverseProcess> {

        @Override
        protected String requestUri() {
            return "/rest/reverse.do";
        }

        public static Request newInstance(ReverseParams reverseParams) {
            return new Request(reverseParams);
        }

        private Request(ReverseParams reverseParams) {
            super(new ReverseProcessTypeAdapter());
            addParameters(reverseParams);
        }

        protected void addParameters(ReverseParams reverseParams) {
            addAuthParameters(reverseParams);
            addParameter("orderId", reverseParams.getOrderId());
            addParameter("language", reverseParams.getLanguage());
        }
    }


}
