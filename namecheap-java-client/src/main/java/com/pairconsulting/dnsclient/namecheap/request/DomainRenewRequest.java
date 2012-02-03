package com.pairconsulting.dnsclient.namecheap.request;


import org.apache.commons.lang.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Properties;

public class DomainRenewRequest extends DNSBaseRequest{

    public DomainRenewRequest(String domainName, Long years, String promoCode, Properties properties) {
        super(properties);
        addParam(new BasicNameValuePair("DomainName", domainName));
        addParam(new BasicNameValuePair("Years", years.toString()));
        if (StringUtils.isNotEmpty(promoCode)) {
            addParam(new BasicNameValuePair("PromotionCode", promoCode));
        }
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.renew";
    }
}
