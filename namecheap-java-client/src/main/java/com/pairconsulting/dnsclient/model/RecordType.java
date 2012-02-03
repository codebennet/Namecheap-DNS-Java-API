package com.pairconsulting.dnsclient.model;


public enum RecordType {

    A,    //IPv4
    AAAA, //IPv6
    CNAME,//forward to other domain
    DNAME, //dynamic forward

    URL //some providers have this - NOT COMMON!!
}
