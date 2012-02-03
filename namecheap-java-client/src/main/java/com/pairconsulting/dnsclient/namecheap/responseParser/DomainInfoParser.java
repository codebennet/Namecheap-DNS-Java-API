package com.pairconsulting.dnsclient.namecheap.responseParser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * See response format
 * http://www.namecheap.com/support/api/domains/namecheap.domains.getinfo.aspx
 */
public class DomainInfoParser extends DefaultHandler implements XmlResponseParser<Map<String,String>> {

    private static final Logger log = LoggerFactory.getLogger(DomainInfoParser.class);

    private SAXParser parser;
    private Map<String,String> result;

    public DomainInfoParser() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        result = new HashMap<String, String>();
    }

    public Map<String,String> parse(String xml) {

        try {
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch(Exception e){
            log.error("Error in parsing string.", e);
        }

        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        //OK, Locked, Expired
        if ("ApiResponse".equalsIgnoreCase(qName)){
            result.put("status", attributes.getValue("Status"));
        }
    }
}
