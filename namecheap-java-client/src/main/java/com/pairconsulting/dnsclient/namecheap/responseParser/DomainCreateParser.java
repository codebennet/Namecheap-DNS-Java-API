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

public class DomainCreateParser extends DefaultHandler implements XmlResponseParser<Domain> {

    private static final Logger log = LoggerFactory.getLogger(DomainCreateParser.class);

    private SAXParser parser;
    private Domain result;

    public DomainCreateParser() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        result = null;
    }

    public Domain parse(String xml) {

        try {
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch(Exception e){
            log.error("Error in parsing string.", e);
        }

        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if ("DomainCreateResult".equalsIgnoreCase(qName) && Boolean.parseBoolean(attributes.getValue("Registered"))){

            result = new Domain(Long.parseLong(attributes.getValue("DomainID")), attributes.getValue("Domain"));
            result.setPrice(Double.parseDouble(attributes.getValue("ChargedAmount")));
        }
    }
}
