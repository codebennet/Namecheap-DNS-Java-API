package com.pairconsulting.dnsclient;


import com.pairconsulting.dnsclient.model.Domain;

import java.util.List;

public interface DNSProvider {

    List<Domain> getDomainsList() throws Exception;

    boolean isDomainFree(Domain domain) throws Exception;

    boolean renewDomain(Domain domain, Long years, String promoCode) throws Exception;

    boolean reactivateDomain(Domain domain) throws Exception;

    boolean isDomainLocked(Domain domain) throws Exception;

    boolean toggleDomainLock(Domain domain, boolean lock) throws Exception;

    Domain addDomain(Domain domain) throws Exception;

    Domain updateDomain(Domain domain) throws Exception;

    String getDomainStatus(Domain domain) throws Exception;

    /**
     * Must be used only once! The response must be cached
     * @return list of top level domains available from provider.
     * @throws Exception if error occur
     */
    List<String> getTldsList() throws Exception;

    boolean deleteDomain(Domain domain) throws Exception;
}
