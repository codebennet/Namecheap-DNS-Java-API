package com.pairconsulting.dnsclient.namecheap.responseParser;


public interface XmlResponseParser<T> {

    T parse(String xml);
}
