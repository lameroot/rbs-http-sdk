package ru.rbs.http.api.domain;

import java.util.HashMap;
import java.util.Map;

public class ReturnUrlObject {

    private String url;
    private ReturnAction action;
    private Map<String,String> params = new HashMap<>();

    public String getUrl() {
        return url;
    }

    public ReturnUrlObject setUrl(String url) {
        this.url = url;
        return this;
    }

    public ReturnAction getAction() {
        return action;
    }

    public ReturnUrlObject setAction(ReturnAction action) {
        this.action = action;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public ReturnUrlObject setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public ReturnUrlObject addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReturnUrlObject{");
        sb.append("url='").append(url).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append(", params size=").append(params.size());
        if ( params.size() > 0 ) {
            int count = 0;
            sb.append(" : [");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                count++;
                sb.append(entry.getKey()).append("=").append(entry.getValue());
                if ( count < params.size() ) sb.append(",");
            }
            sb.append("]");
        }
        sb.append('}');
        return sb.toString();
    }

    public static enum ReturnAction {
        POST,
        GET,
        REDIRECT
    }
}
