package com.pairconsulting.dnsclient.namecheap.request;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public abstract class DNSBaseRequest {

    private List<NameValuePair> params = new ArrayList<NameValuePair>();

    protected DNSBaseRequest(Properties properties) {

        params.add(new BasicNameValuePair("ApiUser", properties.getProperty("api.login")));
        params.add(new BasicNameValuePair("ApiKey", properties.getProperty("api.key")));
        params.add(new BasicNameValuePair("UserName", properties.getProperty("api.login")));
        params.add(new BasicNameValuePair("ClientIp", properties.getProperty("client.ip")));
        //each class has its own command - his purpose
        params.add(new BasicNameValuePair("Command", getCommand()));
    }

    /**
     * Don't allow to remove params
     * @return
     */
    public List<NameValuePair> getParams() {
        return Collections.unmodifiableList(params);
    }

    /**
     * needed only in sub classes
     * @param pair
     */
    protected void addParam(NameValuePair pair) {
        params.add(pair);
    }

    protected abstract String getCommand();

    protected static String[] getDomainLevels(String domainName) {

        String[] names = domainName.split("\\.");

        if (names.length < 2) {
            throw new RuntimeException(new StringBuilder("Domain name ").append(domainName).append(" is invalid.").toString());
        }

        return names;
    }
}
