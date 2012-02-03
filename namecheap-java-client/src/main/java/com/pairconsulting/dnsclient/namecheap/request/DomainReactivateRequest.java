package com.pairconsulting.dnsclient.namecheap.request;


import org.apache.http.message.BasicNameValuePair;

import java.util.Properties;

public class DomainReactivateRequest extends DNSBaseRequest{

    public DomainReactivateRequest(String domainName, Properties properties) {
        super(properties);
        addParam(new BasicNameValuePair("DomainName", domainName));
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.reactivate";
    }
}
