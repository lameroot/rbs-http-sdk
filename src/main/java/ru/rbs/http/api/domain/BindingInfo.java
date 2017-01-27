package ru.rbs.http.api.domain;

public class BindingInfo {
    private String clientId;
    private String bindingId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBindingId() {
        return bindingId;
    }

    public void setBindingId(String bindingId) {
        this.bindingId = bindingId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BindingInfo{");
        sb.append("clientId='").append(clientId).append('\'');
        sb.append(", bindingId='").append(bindingId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
