package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestGetDomainList extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestGetDomainList.class);

    @Test
    @Override
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
        log.debug("Getting domains list...");
        for (Domain d: dnsProvider.getDomainsList()) {
            log.debug("Domain data: {}", d);
        }
    }
}
