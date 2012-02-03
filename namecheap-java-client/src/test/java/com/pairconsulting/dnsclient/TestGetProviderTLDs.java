package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestGetProviderTLDs extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestGetProviderTLDs.class);

    @Override
    @Test
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
        log.debug("Domain tlds:");
        for (String tld: dnsProvider.getTldsList()) {
            log.debug("TLD: '{}'", tld);
        }
    }
}
