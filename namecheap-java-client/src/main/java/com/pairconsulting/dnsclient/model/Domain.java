package com.pairconsulting.dnsclient.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Domain extends BaseModel{
    
    private Long id;
    private String name;
    private String createDate;
    private String expireDate;
    private String updateDate;
    private String registrationStatus;
    private Double price;

    List<DomainRecord> records = new ArrayList<DomainRecord>();

    public Domain() {
    }

    public Domain(String name) {
        this.name = name;
    }

    public Domain(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Domain(String name, DomainRecord record) {
        this.name = name;
        addRecord(record);
    }

    public Long getId() {
        return id;
    }

    public Domain setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Domain setName(String name) {
        this.name = name;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Domain setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public Domain setExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public Domain setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public Domain setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Domain setPrice(Double price) {
        this.price = price;
        return this;
    }

    public List<DomainRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    public Domain addRecord(DomainRecord record) {
        records.add(record);
        return this;
    }
}
