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
import java.util.ArrayList;
import java.util.List;

/**
 * See response format
 * http://www.namecheap.com/support/api/domains/namecheap.domains.getTldList.aspx
 */
public class TldsListParser extends DefaultHandler implements XmlResponseParser<List<String>> {

    private static final Logger log = LoggerFactory.getLogger(TldsListParser.class);

    private SAXParser parser;
    private List<String> result;

    public TldsListParser() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        result = new ArrayList<String>();
    }

    public List<String> parse(String xml) {

        try {
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch(Exception e){
            log.error("Error in parsing string.", e);
        }

        return result;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if ("Tld".equalsIgnoreCase(qName)){
            result.add(attributes.getValue("Name"));
        }
    }
}
