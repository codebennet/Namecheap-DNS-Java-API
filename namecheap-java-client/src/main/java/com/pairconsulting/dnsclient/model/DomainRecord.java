package com.pairconsulting.dnsclient.model;


public class DomainRecord extends BaseModel {

    private Long id;
    private String name;
    private Integer ttl;
    private String createDate;
    private String updateDate;

    private String content;

    private RecordType recordType;

    public DomainRecord() {
    }

    public DomainRecord(String name, String content, RecordType recordType) {
        this.name = name;
        this.content = content;
        this.recordType = recordType;
    }

    public Long getId() {
        return id;
    }

    public DomainRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DomainRecord setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getTtl() {
        return ttl;
    }

    public DomainRecord setTtl(Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public DomainRecord setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public DomainRecord setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public String getContent() {
        return content;
    }

    public DomainRecord setContent(String content) {
        this.content = content;
        return this;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public DomainRecord setRecordType(RecordType recordType) {
        this.recordType = recordType;
        return this;
    }
}
