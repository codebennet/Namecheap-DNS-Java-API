package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCheckDomainAvailable extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestCheckDomainAvailable.class);

    @Test
    @Override
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
//        String name = "google.com";
        String name = "ayavamgo3354-voril1abhrafew009.net";
        log.debug("Domain '{}' is free: '{}'",name, dnsProvider.isDomainFree(new Domain(name)));
    }
}
