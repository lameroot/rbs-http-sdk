package ru.rbs.http.api.client;

import okhttp3.*;
import ru.rbs.http.api.domain.ApiRequest;

import java.util.Map;

import static ru.rbs.http.api.util.Common.checkNotNull;

public class DefaultApiClient implements ApiClient {

    private final CacheControl cacheControl = new CacheControl.Builder().noCache().build();

    private final HostsProvider hostsProvider;
    private final boolean debugMode;
    private final OkHttpClient httpClient;
    private Long timeout = 30L;

    protected DefaultApiClient(Builder builder) {
        hostsProvider = builder.hostsProvider;
        debugMode = builder.debugMode;
        if (null != builder.timeout) timeout = builder.timeout;
        if (builder.httpClient == null) {
            builder.httpClient = HttpClientFactory.newOkHttpClient(debugMode, timeout);
        }
        httpClient = builder.httpClient;
    }

    @Override
    public HostsProvider getHostsProvider() {
        return hostsProvider;
    }

    @Override
    public <T> T execute(ApiRequest<T> request) throws Exception {
        Response response = httpClient.newCall(prepareRequest(request)).execute();
        return request.parse(new OkHttpClientResponse(response, debugMode));
    }

    public static class Builder {

        private boolean debugMode = false;
        private HostsProvider hostsProvider;
        private OkHttpClient httpClient;
        private Long timeout;

        public final Builder setDebugMode(boolean debugMode) {
            this.debugMode = debugMode;
            return this;
        }
        public final Builder setHostsProvider(HostsProvider hostsProvider) {
            this.hostsProvider = checkNotNull(hostsProvider, "hostsProvider");
            return this;
        }
        public final Builder setHttpClient(OkHttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }
        public final Builder setTimeout(Long timeout) {
            this.timeout = timeout;
            return this;
        }
        public DefaultApiClient create() {
            return new DefaultApiClient(this);
        }
    }

    private Request prepareRequest(ApiRequest<?> request) {
        checkNotNull(request, "request");

        Request.Builder builder = new Request.Builder()
                .cacheControl(cacheControl)
                .url(request.requestUrl(getHostsProvider()));

        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                builder.addHeader(entry.getKey(), value);
            }
        }

        ApiRequest.Method method = request.getMethod();
        if (method != ApiRequest.Method.GET) {
            RequestBody body = RequestBody.create(MediaType.parse(request.getContentType()), request.getBody());
            switch (method) {
                case POST:
                    builder.post(body);
                    break;
                case PUT:
                    builder.put(body);
                    break;
            }
        }

        return builder.build();
    }

}
