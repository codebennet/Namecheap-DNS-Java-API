package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.model.DomainRecord;
import com.pairconsulting.dnsclient.model.RecordType;
import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRenewDomain extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestRenewDomain.class);

    @Test
    @Override
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
        String name = "ayavamgovoril1.net";
        log.debug("Domain renew {}", dnsProvider.renewDomain(new Domain(name), 3L, null));
    }
}
