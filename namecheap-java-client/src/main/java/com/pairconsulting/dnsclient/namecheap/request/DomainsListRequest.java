package com.pairconsulting.dnsclient.namecheap.request;


import java.util.Properties;

public class DomainsListRequest extends DNSBaseRequest{

    public DomainsListRequest(Properties properties) {
        super(properties);
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.getList";
    }
}
