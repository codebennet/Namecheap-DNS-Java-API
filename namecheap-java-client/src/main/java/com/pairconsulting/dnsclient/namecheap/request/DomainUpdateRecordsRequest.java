package com.pairconsulting.dnsclient.namecheap.request;


import com.pairconsulting.dnsclient.model.Domain;
import com.pairconsulting.dnsclient.model.DomainRecord;
import org.apache.http.message.BasicNameValuePair;

import java.util.Properties;

public class DomainUpdateRecordsRequest extends DNSBaseRequest{

    public DomainUpdateRecordsRequest(Domain domain, Properties properties){
        super(properties);

        String[] names = getDomainLevels(domain.getName());

        addParam(new BasicNameValuePair("TLD", names[names.length-1]));
        addParam(new BasicNameValuePair("SLD", names[names.length-2]));

        int i=1;
        for (DomainRecord rc: domain.getRecords()) {

            addParam(new BasicNameValuePair(new StringBuilder("HostName").append(i).toString(), rc.getName()));
            addParam(new BasicNameValuePair(new StringBuilder("RecordType").append(i).toString(), rc.getRecordType().toString()));
            addParam(new BasicNameValuePair(new StringBuilder("Address").append(i).toString(), rc.getContent()));
            i++;
        }
    }

    @Override
    protected String getCommand() {
        return "namecheap.domains.dns.setHosts";
    }
}
