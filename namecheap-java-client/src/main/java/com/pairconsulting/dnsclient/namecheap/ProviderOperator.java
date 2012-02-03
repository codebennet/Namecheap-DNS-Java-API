package com.pairconsulting.dnsclient.namecheap;


import com.pairconsulting.dnsclient.namecheap.request.DNSBaseRequest;
import com.pairconsulting.dnsclient.namecheap.request.DNSRequestProcessor;
import com.pairconsulting.dnsclient.namecheap.responseParser.XmlResponseParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bridge-class for common operations - perform request to api and parse response from it.
 */
public class ProviderOperator {

    private static final Logger log = LoggerFactory.getLogger(ProviderOperator.class);

    private DNSRequestProcessor dnsRequestProcessor;

    public ProviderOperator(DNSRequestProcessor dnsRequestProcessor) {
        this.dnsRequestProcessor = dnsRequestProcessor;
    }

    public <T, S extends T> T process(DNSBaseRequest dnsRequest, XmlResponseParser<T> parser, S defaultResult) {

        T result = defaultResult;
        try {
            String xml = dnsRequestProcessor.get(dnsRequest);
            log.debug("Response: {}", xml);
            result = parser.parse(xml);
        } catch (Exception e) {
            log.error("Error in parse", e);
        }
        return result;
    }
}
