package com.pairconsulting.dnsclient.namecheap.request;


import org.apache.http.message.BasicNameValuePair;

import java.util.Properties;

public class DomainCheckRequest extends DNSBaseRequest{

    public DomainCheckRequest(String domainName, Properties properties) {
        super(properties);
        addParam(new BasicNameValuePair("DomainList", domainName));
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.check";
    }
}
