package com.bc.album.boot.spring.config;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultClientConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultHttpClientConnectionOperator;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.net.ProxySelector;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import static org.apache.http.conn.socket.PlainConnectionSocketFactory.getSocketFactory;

/**
 * Rest Template configuration class.
 */
@Configuration
@RequiredArgsConstructor
public class RestTemplateConfiguration implements WebMvcConfigurer  {

    @Autowired
    private AppConfig appConfig;

    /**
     * trustedAll.
     *
     * @return a {@link SSLConnectionSocketFactory} object.
     * @throws KeyStoreException if any.
     * @throws NoSuchAlgorithmException if any.
     * @throws KeyManagementException if any.
     */
    @Bean(name = "trustedAll")
    public SSLConnectionSocketFactory trustedAll()
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLContextBuilder sslContextBuilder =
                new SSLContextBuilder().loadTrustMaterial(null, new TrustAllStrategy());
        return new SSLConnectionSocketFactory(sslContextBuilder.build(), NoopHostnameVerifier.INSTANCE);
    }

    /**
     * pool config for client connections.
     *
     * @param sslConnectionSocketFactory sslConnectionSocketFactory.
     * @return PoolingHttpClientConnectionManager.
     */
    @Bean(name = "poolingHttpClientConnectionManagerCommonBean")
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(
            @Autowired @Qualifier(value = "trustedAll") SSLConnectionSocketFactory sslConnectionSocketFactory) {
        Registry<ConnectionSocketFactory> socketFactoryRegistry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", getSocketFactory())
                        .register("https", sslConnectionSocketFactory)
                        .build();
        final SocketConfig socketConfig =
                SocketConfig.custom().setTcpNoDelay(true).setSoKeepAlive(true).build();
        PoolingHttpClientConnectionManager result =
                new PoolingHttpClientConnectionManager(
                        new DefaultHttpClientConnectionOperator(
                                socketFactoryRegistry,
                                DefaultSchemePortResolver.INSTANCE,
                                SystemDefaultDnsResolver.INSTANCE),
                        ManagedHttpClientConnectionFactory.INSTANCE,
                        20,
                        TimeUnit.SECONDS);
        result.setDefaultSocketConfig(socketConfig);
        result.setValidateAfterInactivity(10000);
        result.setDefaultMaxPerRoute(appConfig.getHttpPool().getMaxPerRoute());
        result.setMaxTotal(appConfig.getHttpPool().getMaxTotal());
        result.closeExpiredConnections();
        result.closeIdleConnections(10, TimeUnit.SECONDS);
        return result;
    }

    /**
     * Request configuration.
     *
     * @return RequestConfig.
     */
    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(appConfig.getHttpPool().getConnectionRequestTimeout())
                .setConnectTimeout(appConfig.getHttpPool().getConnectTimeout())
                .setSocketTimeout(appConfig.getHttpPool().getSocketTimeout())
                .build();
    }

    /**
     * Closeable http client.
     *
     * @param poolingHttpClientConnectionManager pool config
     * @param sslConnectionSocketFactory         ssl connection config
     * @param requestConfig                      request config timeout
     * @return The http client.
     */
    @Bean(name = "httpClient")
    public CloseableHttpClient httpClient(
            @Autowired @Qualifier(value = "poolingHttpClientConnectionManagerCommonBean")
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
            @Autowired @Qualifier(value = "trustedAll")
            SSLConnectionSocketFactory sslConnectionSocketFactory,
            RequestConfig requestConfig) {
        HttpRoutePlanner routePlanner = new SystemDefaultRoutePlanner(ProxySelector.getDefault());
        return HttpClientBuilder.create()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setRoutePlanner(routePlanner)
                .disableCookieManagement()
                .setDefaultRequestConfig(requestConfig)
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .setConnectionReuseStrategy(DefaultClientConnectionReuseStrategy.INSTANCE)
                .evictIdleConnections(10, TimeUnit.SECONDS)
                .evictExpiredConnections()
                .build();
    }

    /**
     * Builds the rest template.
     *
     * @param restTemplateBuilder The rest template builder.
     * @param httpClient The http closable client.
     * @return The rest template.
     */
    @Bean
    public RestTemplate restTemplate(
            RestTemplateBuilder restTemplateBuilder,
            CloseableHttpClient httpClient) {
        return restTemplateBuilder
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .build();
    }

    @Bean
    public RetryTemplate retryTemplate(
            @Value("${com.bc.album.cfg.maxRestTemplateRetries}") int maxRetries) {
        RetryTemplate retryTemplate = new RetryTemplate();
        ExceptionClassifierRetryPolicy policy = new ExceptionClassifierRetryPolicy();
        policy.setExceptionClassifier(new RetryClassifierPolicy(maxRetries));
        retryTemplate.setRetryPolicy(policy);
        return retryTemplate;
    }

}
