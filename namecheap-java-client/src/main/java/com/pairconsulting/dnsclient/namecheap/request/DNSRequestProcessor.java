package com.pairconsulting.dnsclient.namecheap.request;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Properties;

/**
 * Class performs HTTP requests to DNS api
 */
public class DNSRequestProcessor {

    private static final Logger log = LoggerFactory.getLogger(DNSRequestProcessor.class);

    private String apiHost;
    private int statusCode;
    private Properties appSettings;

    public DNSRequestProcessor(Properties configProperties) {

        apiHost = (String) configProperties.get("api.host");
        this.appSettings = configProperties;
    }

    public String get(DNSBaseRequest dnsRequest) {

        byte[] result = {};

        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {

            String paramUri = URLEncodedUtils.format(dnsRequest.getParams(), "UTF-8");
            URI uri = URIUtils.createURI("https", apiHost, -1, "/xml.response", paramUri, null);

            log.debug("URI: {}", uri);
            HttpGet httpget = new HttpGet(uri);

            HttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toByteArray(entity);
            }
            EntityUtils.consume(entity);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            log.error("Http request error.", e);
        } finally {
            try {
                httpClient.getConnectionManager().shutdown();
            } catch (Exception e) {
            }
        }

        return new String(result);
    }
}
