package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCheckDomainLocked extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestCheckDomainLocked.class);

    @Test
    @Override
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
        String name = "ayavamgovoril1.net";
        log.debug("Domain lock: '{}'", dnsProvider.isDomainLocked(new Domain(name)));
        log.debug("Domain unlocking: '{}'", dnsProvider.toggleDomainLock(new Domain(name), false));
        log.debug("Domain lock: '{}'", dnsProvider.isDomainLocked(new Domain(name)));
    }
}
