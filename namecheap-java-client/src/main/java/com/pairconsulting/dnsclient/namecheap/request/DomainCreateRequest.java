package com.pairconsulting.dnsclient.namecheap.request;


import com.pairconsulting.dnsclient.model.Domain;
import org.apache.commons.lang.StringUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Properties;

public class DomainCreateRequest extends DNSBaseRequest{

    public DomainCreateRequest(Domain domain, Properties properties) {
        super(properties);

        addParam(new BasicNameValuePair("DomainName", domain.getName()));
        addParam(new BasicNameValuePair("Years", "1"));

        //registrant
        addParam(new BasicNameValuePair("RegistrantFirstName", properties.getProperty("RegistrantFirstName")));
        addParam(new BasicNameValuePair("RegistrantLastName", properties.getProperty("RegistrantLastName")));
        addParam(new BasicNameValuePair("RegistrantAddress1", properties.getProperty("RegistrantAddress1")));
        addParam(new BasicNameValuePair("RegistrantCity", properties.getProperty("RegistrantCity")));
        addParam(new BasicNameValuePair("RegistrantStateProvince", properties.getProperty("RegistrantStateProvince")));
        addParam(new BasicNameValuePair("RegistrantPostalCode", properties.getProperty("RegistrantPostalCode")));
        addParam(new BasicNameValuePair("RegistrantCountry", properties.getProperty("RegistrantCountry")));
        addParam(new BasicNameValuePair("RegistrantPhone", properties.getProperty("RegistrantPhone")));
        addParam(new BasicNameValuePair("RegistrantEmailAddress", properties.getProperty("RegistrantEmailAddress")));

        //tech info
        addParam(new BasicNameValuePair("TechFirstName",
                StringUtils.isNotEmpty(properties.getProperty("TechFirstName")) ? properties.getProperty("TechFirstName") : properties.getProperty("RegistrantFirstName")));
        addParam(new BasicNameValuePair("TechLastName",
                StringUtils.isNotEmpty(properties.getProperty("TechLastName")) ? properties.getProperty("TechLastName") : properties.getProperty("RegistrantLastName")));
        addParam(new BasicNameValuePair("TechAddress1",
                StringUtils.isNotEmpty(properties.getProperty("TechAddress1")) ? properties.getProperty("TechAddress1") : properties.getProperty("RegistrantAddress1")));
        addParam(new BasicNameValuePair("TechCity",
                StringUtils.isNotEmpty(properties.getProperty("TechCity")) ? properties.getProperty("TechCity") : properties.getProperty("RegistrantCity")));
        addParam(new BasicNameValuePair("TechStateProvince",
                StringUtils.isNotEmpty(properties.getProperty("TechStateProvince")) ? properties.getProperty("TechStateProvince") : properties.getProperty("RegistrantStateProvince")));
        addParam(new BasicNameValuePair("TechPostalCode",
                StringUtils.isNotEmpty(properties.getProperty("TechPostalCode")) ? properties.getProperty("TechPostalCode") : properties.getProperty("RegistrantPostalCode")));
        addParam(new BasicNameValuePair("TechCountry",
                StringUtils.isNotEmpty(properties.getProperty("TechCountry")) ? properties.getProperty("TechCountry") : properties.getProperty("RegistrantCountry")));
        addParam(new BasicNameValuePair("TechPhone",
                StringUtils.isNotEmpty(properties.getProperty("TechPhone")) ? properties.getProperty("TechPhone") : properties.getProperty("RegistrantPhone")));
        addParam(new BasicNameValuePair("TechEmailAddress",
                StringUtils.isNotEmpty(properties.getProperty("TechEmailAddress")) ? properties.getProperty("TechEmailAddress") : properties.getProperty("RegistrantEmailAddress")));

        //admin info
        addParam(new BasicNameValuePair("AdminFirstName",
                StringUtils.isNotEmpty(properties.getProperty("AdminFirstName")) ? properties.getProperty("AdminFirstName") : properties.getProperty("RegistrantFirstName")));
        addParam(new BasicNameValuePair("AdminLastName",
                StringUtils.isNotEmpty(properties.getProperty("AdminLastName")) ? properties.getProperty("AdminLastName") : properties.getProperty("RegistrantLastName")));
        addParam(new BasicNameValuePair("AdminAddress1",
                StringUtils.isNotEmpty(properties.getProperty("AdminAddress1")) ? properties.getProperty("AdminAddress1") : properties.getProperty("RegistrantAddress1")));
        addParam(new BasicNameValuePair("AdminCity",
                StringUtils.isNotEmpty(properties.getProperty("AdminCity")) ? properties.getProperty("AdminCity") : properties.getProperty("RegistrantCity")));
        addParam(new BasicNameValuePair("AdminStateProvince",
                StringUtils.isNotEmpty(properties.getProperty("AdminStateProvince")) ? properties.getProperty("AdminStateProvince") : properties.getProperty("RegistrantStateProvince")));
        addParam(new BasicNameValuePair("AdminPostalCode",
                StringUtils.isNotEmpty(properties.getProperty("AdminPostalCode")) ? properties.getProperty("AdminPostalCode") : properties.getProperty("RegistrantPostalCode")));
        addParam(new BasicNameValuePair("AdminCountry",
                StringUtils.isNotEmpty(properties.getProperty("AdminCountry")) ? properties.getProperty("AdminCountry") : properties.getProperty("RegistrantCountry")));
        addParam(new BasicNameValuePair("AdminPhone",
                StringUtils.isNotEmpty(properties.getProperty("AdminPhone")) ? properties.getProperty("AdminPhone") : properties.getProperty("RegistrantPhone")));
        addParam(new BasicNameValuePair("AdminEmailAddress",
                StringUtils.isNotEmpty(properties.getProperty("AdminEmailAddress")) ? properties.getProperty("AdminEmailAddress") : properties.getProperty("RegistrantEmailAddress")));

        //auxiliary billing info
        addParam(new BasicNameValuePair("AuxBillingFirstName",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingFirstName")) ? properties.getProperty("AuxBillingFirstName") : properties.getProperty("RegistrantFirstName")));
        addParam(new BasicNameValuePair("AuxBillingLastName",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingLastName")) ? properties.getProperty("AuxBillingLastName") : properties.getProperty("RegistrantLastName")));
        addParam(new BasicNameValuePair("AuxBillingAddress1",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingAddress1")) ? properties.getProperty("AuxBillingAddress1") : properties.getProperty("RegistrantAddress1")));
        addParam(new BasicNameValuePair("AuxBillingCity",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingCity")) ? properties.getProperty("AuxBillingCity") : properties.getProperty("RegistrantCity")));
        addParam(new BasicNameValuePair("AuxBillingStateProvince",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingStateProvince")) ? properties.getProperty("AuxBillingStateProvince") : properties.getProperty("RegistrantStateProvince")));
        addParam(new BasicNameValuePair("AuxBillingPostalCode",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingPostalCode")) ? properties.getProperty("AuxBillingPostalCode") : properties.getProperty("RegistrantPostalCode")));
        addParam(new BasicNameValuePair("AuxBillingCountry",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingCountry")) ? properties.getProperty("AuxBillingCountry") : properties.getProperty("RegistrantCountry")));
        addParam(new BasicNameValuePair("AuxBillingPhone",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingPhone")) ? properties.getProperty("AuxBillingPhone") : properties.getProperty("RegistrantPhone")));
        addParam(new BasicNameValuePair("AuxBillingEmailAddress",
                StringUtils.isNotEmpty(properties.getProperty("AuxBillingEmailAddress")) ? properties.getProperty("AuxBillingEmailAddress") : properties.getProperty("RegistrantEmailAddress")));

        String[] dls = getDomainLevels(domain.getName());

        if (dls[dls.length-1].equals("ca")) {
            addParam(new BasicNameValuePair("CIRAAgreementVersion", "2.0"));
            addParam(new BasicNameValuePair("CIRAAgreementValue", "Y"));
            addParam(new BasicNameValuePair("CIRAType", properties.getProperty("CIRAType")));
            addParam(new BasicNameValuePair("CIRAWhoisDisplay", properties.getProperty("CIRAWhoisDisplay")));
        }
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.create";
    }
}
