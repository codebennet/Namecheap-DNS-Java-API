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

public class DomainCheckParser extends DefaultHandler implements XmlResponseParser<Boolean> {

    private static final Logger log = LoggerFactory.getLogger(DomainCheckParser.class);

    private SAXParser parser;
    private Boolean result;
    private String domainName;

    public DomainCheckParser(String domainName) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        result = Boolean.FALSE;
        this.domainName = domainName;
    }

    public Boolean parse(String xml) {

        try {
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch(Exception e){
            log.error("Error in parsing string.", e);
        }

        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if ("DomainCheckResult".equalsIgnoreCase(qName) &&
                domainName.equals(attributes.getValue("Domain"))){

            result = Boolean.parseBoolean(attributes.getValue("Available"));
        }
    }
}
