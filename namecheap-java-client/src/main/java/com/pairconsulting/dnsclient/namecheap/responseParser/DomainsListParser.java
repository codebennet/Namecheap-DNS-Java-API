package com.pairconsulting.dnsclient.namecheap.responseParser;


import com.pairconsulting.dnsclient.model.Domain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.util.ArrayList;

public class DomainsListParser extends DefaultHandler implements XmlResponseParser<ArrayList<Domain>> {

    private static final Logger log = LoggerFactory.getLogger(DomainsListParser.class);

    private SAXParser parser;
    private ArrayList<Domain> result;

    public DomainsListParser() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        result = new ArrayList<Domain>();
    }

    public ArrayList<Domain> parse(String xml) {

        try {
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch(Exception e){
            log.error("Error in parsing string.", e);
        }

        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if ("Domain".equalsIgnoreCase(qName)){
            Domain domain = new Domain(Long.parseLong(attributes.getValue("ID")), attributes.getValue("Name"));
            domain.setCreateDate(attributes.getValue("Created"));
            domain.setExpireDate(attributes.getValue("Expires"));

            result.add(domain);
        }
    }
}
