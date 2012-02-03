package com.pairconsulting.dnsclient.namecheap.request;


import java.util.Properties;

public class TldsListRequest extends DNSBaseRequest {

    public TldsListRequest(Properties properties) {
        super(properties);
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.getTldList";
    }
}
