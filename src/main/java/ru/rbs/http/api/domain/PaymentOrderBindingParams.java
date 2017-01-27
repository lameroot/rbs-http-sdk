package ru.rbs.http.api.domain;

public class PaymentOrderBindingParams extends AuthParams {

    private String mdOrder;
    private String bindingId;
    private String language;
    private String ip;
    private String cvc;
    private String email;

    public PaymentOrderBindingParams() {
    }

    public PaymentOrderBindingParams(String userName, String password, String hostProviderUrl) {
        super(userName, password, hostProviderUrl);
    }

    public String getMdOrder() {
        return mdOrder;
    }

    public void setMdOrder(String mdOrder) {
        this.mdOrder = mdOrder;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
