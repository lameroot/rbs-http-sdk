package ru.rbs.http.api.domain;


import ru.rbs.http.api.client.HostsProvider;
import ru.rbs.http.api.exception.InvalidRequestException;
import ru.rbs.http.api.methods.adapters.TypeAdapter;
import ru.rbs.http.api.util.MimeTypes;
import ru.rbs.http.api.util.ParametersBuffer;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseApiRequest<T> implements ApiRequest<T> {

    private final Map<String, String> headers = new HashMap();
    private final Map<String, String> parameters = new HashMap();
    private byte[] body;
    private final ParametersBuffer buffer = new ParametersBuffer();
    private final TypeAdapter<T> typeAdapter;
    private String overrideHostProviderUrl;

    public BaseApiRequest(TypeAdapter<T> typeAdapter) {
        this.typeAdapter = typeAdapter;
    }

    @Override
    public final T parse(HttpClientResponse response) throws Exception {
        InputStream inputStream = null;

        try {
            switch (response.getCode()) {
                case HttpURLConnection.HTTP_OK:
                case HttpURLConnection.HTTP_ACCEPTED:
                case HttpURLConnection.HTTP_BAD_REQUEST:
                    return typeAdapter.fromJson(response.getBody());
                    //return objectMapper.readValue(response.getByteStream(), type);
                default:
                    throw new InvalidRequestException("error");
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override
    public final Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    @Override
    public final Map<String, String> getParameters() {
        return Collections.unmodifiableMap(parameters);
    }

    @Override
    public String getContentType() {
        return MimeTypes.Application.X_WWW_FORM_URLENCODED;
    }

    @Override
    public final byte[] getBody() {
        prepareBody();
        return body == null ? buffer.setParameters(parameters).prepareBytes() : body;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String requestUrl(HostsProvider hostsProvider) {
        String url = requestUrlBase(hostsProvider);
        return getMethod() == Method.GET ? url + buffer.setParameters(parameters).prepareGet() : url;
    }

    protected final void addHeader(String key, String value) {
        headers.put(key, value);
    }

    /**
     * Adds collection of headers.
     *
     * @param headers headers to add
     */
    protected final void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    /**
     * Adds {@link String} parameter to this request.
     *
     * @param key key
     * @param value value
     */
    protected final void addParameter(String key, String value) {
        parameters.put(key, value);
    }

    protected final void addAuthParameters(AuthParams authParams) {
        addParameter("userName", authParams.getUserName());
        addParameter("password", authParams.getPassword());
        setOverrideHostProviderUrl(authParams.getHostProviderUrl());
    }

    /**
     * Adds {@link Integer} parameter to this request.
     *
     * @param key key
     * @param value value
     */
    protected final void addParameter(String key, Integer value) {
        addParameter(key, value == null ? null : value.toString());
    }

    /**
     * Adds {@link Long} parameter to this request.
     *
     * @param key key
     * @param value value
     */
    protected final void addParameter(String key, Long value) {
        addParameter(key, value == null ? null : value.toString());
    }

    /**
     * Adds {@link Double} parameter to this request.
     *
     * @param key key
     * @param value value
     */
    protected final void addParameter(String key, Double value) {
        addParameter(key, value == null ? null : value.toString());
    }

    /**
     * Adds {@link Boolean} parameter to this request.
     *
     * @param key key
     * @param value value
     */
    protected final void addParameter(String key, Boolean value) {
        addParameter(key, value == null ? null : value.toString());
    }

    /**
     * Adds {@link BigDecimal} parameter to this request.
     *
     * @param key key
     * @param value value
     */
    protected final void addParameter(String key, BigDecimal value) {
        addParameter(key, value == null ? null : value.toPlainString());
    }

    /**
     * Adds collection of parameters.
     *
     * @param parameters parameters to add
     */
    protected final void addParameters(Map<String, String> parameters) {
        this.parameters.putAll(parameters);
    }

    /**
     * Sets a body for a request. Will override any added parameters if not {code null}.
     *
     * @param body body of a request
     */
    protected final void setBody(byte[] body) {
        this.body = body;
    }

    protected void prepareBody() {
    }

    protected String requestUrlBase(HostsProvider hostsProvider) {
        return (null != overrideHostProviderUrl ? overrideHostProviderUrl : hostsProvider.getRbsApi()) + requestUri();
    }

    protected abstract String requestUri();

    protected String getOverrideHostProviderUrl() {
        return overrideHostProviderUrl;
    }

    protected void setOverrideHostProviderUrl(String overrideHostProviderUrl) {
        this.overrideHostProviderUrl = overrideHostProviderUrl;
    }
}
