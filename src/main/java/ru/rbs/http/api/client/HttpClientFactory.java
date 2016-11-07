package ru.rbs.http.api.client;


import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

import static ru.rbs.http.api.util.Common.checkNotNull;

public class HttpClientFactory {

    private HttpClientFactory() {
    }

    /**
     * Creates new {@link OkHttpClient} instance.
     *
     * @param enableLogging {@code true} if logging is required
     * @return new HTTP client
     */
    public static OkHttpClient newOkHttpClient(boolean enableLogging) {
        OkHttpClient.Builder builder = createDefaultOkHttpClientBuilder();
        if (enableLogging) {
            applyLogging(builder);
        }
        return builder.build();
    }

    /**
     * Creates {@link OkHttpClient.Builder} initialized with default parameters.
     *
     * @return instance of {@link OkHttpClient.Builder}
     */
    public static OkHttpClient.Builder createDefaultOkHttpClientBuilder() {
        final long timeout = 30;
        return new OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(4, 10L, TimeUnit.MINUTES))
                .followSslRedirects(false)
                .followRedirects(false);
    }

    /**
     * Applies logging.
     *
     * @param builder builder that will be used to create HTTP client
     */
    public static void applyLogging(OkHttpClient.Builder builder) {
        applyLogging(builder, createSslSocketFactory());
    }

    /**
     * Applies logging to OkHttp client.
     *
     * @param builder OkHttp client builder
     * @param sslSocketFactory SSL socket factory
     */
    public static void applyLogging(OkHttpClient.Builder builder, SSLSocketFactory sslSocketFactory) {
        checkNotNull(builder, "builder").sslSocketFactory(new WireLoggingSocketFactory(sslSocketFactory));
    }

    private static SSLSocketFactory createSslSocketFactory() {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            return context.getSocketFactory();
        } catch (GeneralSecurityException exception) {
            throw new RuntimeException(exception);
        }
    }
}
