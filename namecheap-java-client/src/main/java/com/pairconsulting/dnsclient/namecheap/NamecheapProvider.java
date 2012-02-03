package com.pairconsulting.dnsclient.namecheap;


import com.pairconsulting.dnsclient.DNSProvider;
import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.namecheap.request.*;
import com.pairconsulting.dnsclient.namecheap.responseParser.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Class implements DNS operation for usage with http://www.namecheap.com/
 */
public class NamecheapProvider implements DNSProvider {

    private static final Logger log = LoggerFactory.getLogger(NamecheapProvider.class);

    private Properties configProperties;
    private ProviderOperator operator;

    public NamecheapProvider() throws Exception{

        configProperties = new Properties();
        configProperties.load(getClass().getClassLoader().getResourceAsStream("namecheap.properties"));

        DNSRequestProcessor dnsRequestProcessor = new DNSRequestProcessor(configProperties);
        operator = new ProviderOperator(dnsRequestProcessor);
    }

    @Override
    public List<Domain> getDomainsList() throws Exception {

        return operator.process(
                new DomainsListRequest(configProperties),
                new DomainsListParser(),
                new ArrayList<Domain>());
    }

    @Override
    public boolean isDomainFree(Domain domain) throws Exception {

        return operator.process(
                new DomainCheckRequest(domain.getName(), configProperties),
                new DomainCheckParser(domain.getName()),
                Boolean.FALSE);
    }

    @Override
    public boolean renewDomain(Domain domain, Long years, String promoCode) throws Exception {

        return operator.process(
                new DomainRenewRequest(domain.getName(), years, promoCode, configProperties),
                new DomainRenewParser(domain.getName()),
                Boolean.FALSE);
    }

    @Override
    public boolean reactivateDomain(Domain domain) throws Exception {

        return operator.process(
                new DomainReactivateRequest(domain.getName(), configProperties),
                new DomainReactivateParser(domain.getName()),
                Boolean.FALSE);
    }

    @Override
    public boolean isDomainLocked(Domain domain) throws Exception {

        return operator.process(
                new DomainGetRegistrarLockRequest(domain.getName(), configProperties),
                new DomainGetRegistrarLockParser(domain.getName()),
                Boolean.FALSE);
    }

    @Override
    public boolean toggleDomainLock(Domain domain, boolean lock) throws Exception {

        return operator.process(
                new DomainSetRegistrarLockRequest(domain.getName(), lock, configProperties),
                new DomainSetRegistrarLockParser(domain.getName()),
                Boolean.FALSE);
    }

    @Override
    public Domain addDomain(Domain domain) throws Exception {

        //add domain
        Domain result = operator.process(new DomainCreateRequest(domain, configProperties), new DomainCreateParser(), new Domain());

        //set records for domain
        if (!operator.process(new DomainUpdateRecordsRequest(domain, configProperties), new DomainAddRecordParser(domain.getName()), Boolean.FALSE)) {
            throw new Exception("Error adding domain record.");
        }

        return result;
    }

    @Override
    public Domain updateDomain(Domain domain) throws Exception {

        if (!operator.process(new DomainUpdateRecordsRequest(domain, configProperties), new DomainAddRecordParser(domain.getName()), Boolean.FALSE)) {
            throw new Exception("Error editing domain record.");
        }

        return domain;
    }

    @Override
    public String getDomainStatus(Domain domain) throws Exception {
        
        String result = "OK";

        Map<String,String> map = operator.process(new DomainInfoRequest(domain.getName(), configProperties), new DomainInfoParser(), new HashMap<String, String>());
        if (map.containsKey("status")) {
            result = map.get("status");
        }

        return result;
    }

    @Override
    public List<String> getTldsList() throws Exception {

        return operator.process(new TldsListRequest(configProperties), new TldsListParser(), new ArrayList<String>());
    }

    @Override
    public boolean deleteDomain(Domain domain) throws Exception {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
