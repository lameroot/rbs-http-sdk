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
        paymentOrderProcess.info = jsonNode.get("info").asText();
        ReturnUrlObject returnUrlObject = new ReturnUrlObject();
        if ( jsonNode.has("acsUrl") ) {//3ds payment
            returnUrlObject.setAction(ReturnUrlObject.ReturnAction.POST);
            returnUrlObject.setUrl(jsonNode.get("acsUrl").asText());
            returnUrlObject.addParam("paReq",jsonNode.get("paReq").asText());
            returnUrlObject.addParam("termUrl",jsonNode.get("termUrl").asText());
        }
        else {//ssl
            returnUrlObject.setAction(ReturnUrlObject.ReturnAction.REDIRECT);
            returnUrlObject.setUrl(jsonNode.get("redirect").asText());
        }

        paymentOrderProcess.returnUrlObject = returnUrlObject;
        return paymentOrderProcess;
    }
}
