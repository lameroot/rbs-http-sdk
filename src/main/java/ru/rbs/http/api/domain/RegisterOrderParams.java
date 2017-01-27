package ru.rbs.http.api.domain;

public class RegisterOrderParams extends AuthParams {

    private String orderNumber;
    private Long amount;
    private String currency;
    private String returnUrl;
    private String failUrl;
    private String description;
    private String language;
    private PageView pageView = PageView.DESKTOP;
    private String clientId;
    private String merchantLogin;
    private JsonParams jsonParams = new JsonParams();
    private Integer sessionTimeoutSecs;
    private String expirationDate;
    private String bindingId;

    public RegisterOrderParams() {
    }

    public RegisterOrderParams(String userName, String password, String hostProviderUrl) {
        super(userName, password, hostProviderUrl);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public PageView getPageView() {
        return pageView;
    }

    public void setPageView(PageView pageView) {
        this.pageView = pageView;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getMerchantLogin() {
        return merchantLogin;
    }

    public void setMerchantLogin(String merchantLogin) {
        this.merchantLogin = merchantLogin;
    }

    public Integer getSessionTimeoutSecs() {
        return sessionTimeoutSecs;
    }

    public void setSessionTimeoutSecs(Integer sessionTimeoutSecs) {
        this.sessionTimeoutSecs = sessionTimeoutSecs;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    public JsonParams getJsonParams() {
        return jsonParams;
    }

    public void setJsonParams(JsonParams jsonParams) {
        this.jsonParams = jsonParams;
    }
}
