package ru.rbs.http.api.domain;

public class BindingInfo {
    public String clientId;
    public String bindingId;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BindingInfo{");
        sb.append("clientId='").append(clientId).append('\'');
        sb.append(", bindingId='").append(bindingId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
