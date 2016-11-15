package ru.rbs.http.api.methods.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import ru.rbs.http.api.domain.ReturnUrlObject;
import ru.rbs.http.api.methods.PaymentOrderProcess;

import java.io.IOException;

public class PaymentOrderProcessProcessTypeAdapter extends BaseProcessTypeAdapter<PaymentOrderProcess> {

    @Override
    public Class<PaymentOrderProcess> getType() {
        return PaymentOrderProcess.class;
    }

    @Override
    public PaymentOrderProcess fromJson(String json) throws IOException {
        PaymentOrderProcess paymentOrderProcess = new PaymentOrderProcess();

        JsonNode jsonNode = objectMapper.readTree(json);
        if ( jsonNode.has("errorCode") && 0 != jsonNode.get("errorCode").asInt() ) {
            paymentOrderProcess.setErrorCode(jsonNode.get("errorCode").asInt());
            paymentOrderProcess.setErrorMessage(jsonNode.get("errorMessage").asText());
            return paymentOrderProcess;
        }
        paymentOrderProcess.info = jsonNode.has("info") ? jsonNode.get("info").asText() : null;
        ReturnUrlObject returnUrlObject = new ReturnUrlObject();
        if ( jsonNode.has("acsUrl") ) {//3ds payment
            returnUrlObject.setAction(ReturnUrlObject.ReturnAction.POST);
            returnUrlObject.setUrl(jsonNode.get("acsUrl").asText());
            returnUrlObject.addParam("paReq",jsonNode.has("paReq") ? jsonNode.get("paReq").asText() : null);
            returnUrlObject.addParam("termUrl",jsonNode.has("termUrl") ? jsonNode.get("termUrl").asText() : null);
        }
        else {//ssl
            returnUrlObject.setAction(ReturnUrlObject.ReturnAction.REDIRECT);
            returnUrlObject.setUrl(jsonNode.has("redirect") ? jsonNode.get("redirect").asText() : null);
        }

        paymentOrderProcess.returnUrlObject = returnUrlObject;
        return paymentOrderProcess;
    }
}
