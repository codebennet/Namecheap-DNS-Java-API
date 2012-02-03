package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.model.DomainRecord;
import com.pairconsulting.dnsclient.model.RecordType;
import com.pairconsulting.dnsclient.namecheap.NamecheapProvider;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAddDomain extends AbstractTestCase{

    private static final Logger log = LoggerFactory.getLogger(TestAddDomain.class);

    @Override
    @Test
    public void execute() throws Exception {
        DNSProvider dnsProvider = new NamecheapProvider();
        //create random domain - for test to pass w/o fails
        String postfix = RandomStringUtils.randomAlphanumeric(7);
        String name = "afdha223nalims-" + postfix +"-testo1.com";
        Domain domain = new Domain(name, new DomainRecord("@", "http://google.ca/maps", RecordType.URL));
        domain.addRecord(new DomainRecord("www", "http://google.ca/maps", RecordType.URL));
        log.debug("Created Domain {}", dnsProvider.addDomain(domain));
    }
}
