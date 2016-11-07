package ru.rbs.http.api.domain;

public class PaymentOrderParams extends AuthParams {

    private String language;
    private String mdOrder;
    private String paymentWay;
    private String params;
    private String pan;
    private String cvc;
    private String expiry;
    private String cardHolder;
    private String login;
    private String ip = "-";
    private String eci;
    private String cavv;
    private String xid;
    private String email;
    private boolean bindingNotNeeded;
    private String bindingId;
    private String pointsAmount;
    private String loyaltyId;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMdOrder() {
        return mdOrder;
    }

    public void setMdOrder(String mdOrder) {
        this.mdOrder = mdOrder;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBindingNotNeeded() {
        return bindingNotNeeded;
    }

    public void setBindingNotNeeded(boolean bindingNotNeeded) {
        this.bindingNotNeeded = bindingNotNeeded;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public String getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(String pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    public String getLoyaltyId() {
        return loyaltyId;
    }

    public void setLoyaltyId(String loyaltyId) {
        this.loyaltyId = loyaltyId;
    }
}
