package ru.rbs.http.api.methods.adapters;

import com.fasterxml.jackson.databind.JsonNode;
import ru.rbs.http.api.domain.ReturnUrlObject;
import ru.rbs.http.api.methods.PaymentOrderBindingProcess;

import java.io.IOException;

public class PaymentOrderBindingProcessTypeAdapter extends BaseProcessTypeAdapter<PaymentOrderBindingProcess>{

    @Override
    public Class<PaymentOrderBindingProcess> getType() {
        return PaymentOrderBindingProcess.class;
    }

    @Override
    public PaymentOrderBindingProcess fromJson(String json) throws IOException {
        PaymentOrderBindingProcess paymentOrderBindingProcess = new PaymentOrderBindingProcess();

        JsonNode jsonNode = objectMapper.readTree(json);
        if ( jsonNode.has("errorCode") && 0 != jsonNode.get("errorCode").asInt() ) {
            paymentOrderBindingProcess.setErrorCode(jsonNode.get("errorCode").asInt());
            paymentOrderBindingProcess.setErrorMessage(jsonNode.get("errorMessage").asText());
            return paymentOrderBindingProcess;
        }
        if ( jsonNode.has("errorCode") ) paymentOrderBindingProcess.setErrorCode(jsonNode.get("errorCode").asInt());
        else paymentOrderBindingProcess.setErrorCode(0);
        if ( jsonNode.has("errorMessage") ) paymentOrderBindingProcess.setErrorMessage(jsonNode.get("errorMessage").asText());
        else paymentOrderBindingProcess.setErrorMessage("Success message");

        paymentOrderBindingProcess.setInfo(jsonNode.has("info") ? jsonNode.get("info").asText() : null);
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

        paymentOrderBindingProcess.setReturnUrlObject(returnUrlObject);
        return paymentOrderBindingProcess;
    }
}
