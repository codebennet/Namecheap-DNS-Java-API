package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.model.DomainRecord;
import com.pairconsulting.dnsclient.model.RecordType;
import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUpdateDomain extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestUpdateDomain.class);

    @Test
    @Override
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
        String name = "ayavamgovoril-test5.net";
        Domain domain = new Domain(name, new DomainRecord("@", "77.13.125.231", RecordType.A));
        domain.addRecord(new DomainRecord("www", name, RecordType.CNAME));
        log.debug("Update Domain {}", dnsProvider.updateDomain(domain));
    }
}
