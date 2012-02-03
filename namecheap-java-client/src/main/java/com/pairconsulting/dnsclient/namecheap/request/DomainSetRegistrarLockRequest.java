package com.pairconsulting.dnsclient.namecheap.request;


import org.apache.http.message.BasicNameValuePair;

import java.util.Properties;

public class DomainSetRegistrarLockRequest extends DNSBaseRequest {

    public DomainSetRegistrarLockRequest(String domainName, Boolean lock, Properties properties) {
        super(properties);
        addParam(new BasicNameValuePair("DomainName", domainName));
        if (lock) {
            addParam(new BasicNameValuePair("LockAction", "LOCK"));
        } else {
            addParam(new BasicNameValuePair("LockAction", "UNLOCK"));
        }
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.setRegistrarLock";
    }
}
